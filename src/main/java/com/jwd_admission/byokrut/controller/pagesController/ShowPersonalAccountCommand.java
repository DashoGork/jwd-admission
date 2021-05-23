package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.entity.PersonalInformation;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.dao.FacultyDao;
import com.jwd_admission.byokrut.dao.InformationDao;
import com.jwd_admission.byokrut.dao.RequestDao;
import com.jwd_admission.byokrut.dao.UserDao;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.PERSONAL_ACCOUNT_PAGE;

public class ShowPersonalAccountCommand implements Command {
    private static Connection connection = ConnectionPool.INSTANCE.getConnection();
    private static UserDao userDao = new UserDao(connection);
    private static InformationDao informationDao = new InformationDao(connection);
    private static RequestDao requestDao = new RequestDao(connection);
    private static FacultyDao facultyDao = new FacultyDao(connection);


    public static final CommandResponse COMMAND_RESPONSE = new CommandResponse() {
        @Override
        public boolean isRedirect() {
            return false;
        }

        @Override
        public Destination getDestination() {
            return PERSONAL_ACCOUNT_PAGE;
        }

    };


    @Override
    public CommandResponse execute(CommandRequest request) {
        HttpSession session = request.createSession();
        int role = Integer.parseInt(String.valueOf(session.getAttribute("role")));
        if (role == 1) {
            List<PersonalInformation> personalInformationList = informationDao.findAll();
            List<User> userList = new ArrayList<>();
            for (PersonalInformation information : personalInformationList) {
                User user = userDao.findUserByInfId(information.getId());
                user.setPersonalInformation(information);
                userList.add(user);
            }
            List<Request> userReq = requestDao.findAll();
            request.setAttribute("users", userList);
            request.setAttribute("req", userReq);
        } else {
            User user = new User();
            user.setRoleId(Integer.parseInt(String.valueOf(session.getAttribute("role"))));
            user.setLogin(session.getAttribute("login").toString());
            user.setId(userDao.findUserId(user));
            user = userDao.findEntityById(user.getId());
            user.setPersonalInformation(informationDao.findEntityById(user.getPersonalInformation().getId()));
            Request userRequest = requestDao.findRequestByUser(user.getId());
            request.setAttribute("user", user);
            session.setAttribute("req", userRequest);
            request.setAttribute("faculty", facultyDao.findEntityById(userRequest.getFacultyId()));
        }
        return COMMAND_RESPONSE;
    }
}
