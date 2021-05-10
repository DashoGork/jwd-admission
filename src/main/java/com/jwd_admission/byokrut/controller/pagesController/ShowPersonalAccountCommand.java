package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.FacultyDaoImpl;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.PERSONAL_ACCOUNT_PAGE;

public class ShowPersonalAccountCommand implements Command {
    private UserDaoImpl userDao = new UserDaoImpl();
    private RequestDaoImpl requestDao = new RequestDaoImpl();
    private InformationDaoImpl informationDao = new InformationDaoImpl();
    private FacultyDaoImpl facultyDao = new FacultyDaoImpl();


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
            List<User> userList = informationDao.findAll();
            for (User user : userList) {
                User.copyAllNotNullFields(user, userDao.findEntityByInfId(user.getInfId()));
            }
            List<Request> userReq = requestDao.findAll();
            request.setAttribute("users", userList);
            request.setAttribute("req", userReq);
        } else {
            User user = new User();
            user.setRoleId(Integer.parseInt(String.valueOf(session.getAttribute("role"))));
            user.setLogin(session.getAttribute("login").toString());
            user.setId(userDao.findUserId(user));

            User.copyAllNotNullFields(user, userDao.findEntityById(user.getId()));
            User.copyAllNotNullFields(user, informationDao.findEntityById(user.getInfId()));

            Request userRequest = requestDao.findRequestByUser(user);

            request.setAttribute("user", user);
            session.setAttribute("req", userRequest);
            request.setAttribute("faculty", facultyDao.findEntityById(userRequest.getFacultyId()));
        }
        return COMMAND_RESPONSE;
    }
}
