package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.entity.PersonalInformation;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.newDao.InformationDao;
import com.jwd_admission.byokrut.newDao.RequestDao;
import com.jwd_admission.byokrut.newDao.UserDao;
import com.jwd_admission.byokrut.newDao.services.InformationDaoService;
import com.jwd_admission.byokrut.newDao.services.UserDaoService;

import javax.servlet.http.HttpSession;

import java.sql.Connection;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class UserRegistrationCommand implements Command {
    private static Connection connection = ConnectionPool.INSTANCE.getConnection();
    private static UserDao userDao = new UserDao(connection);
    private static InformationDao informationDao = new InformationDao(connection);
    private static RequestDao requestDao = new RequestDao(connection);

    public static final CommandResponse COMMAND_RESPONSE = new CommandResponse() {
        @Override
        public boolean isRedirect() {
            return false;
        }

        @Override
        public Destination getDestination() {
            return MAIN_PAGE;
        }

    };

    @Override
    public CommandResponse execute(CommandRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String middleNme = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        int score1 = Integer.parseInt(request.getParameter("score_1"));
        int score2 = Integer.parseInt(request.getParameter("score_2"));
        int score3 = Integer.parseInt(request.getParameter("score_3"));
        int score4 = Integer.parseInt(request.getParameter("score_4"));
        int faculty = Integer.parseInt(request.getParameter("faculty"));
        String passportId = request.getParameter("passport_id");
        PersonalInformation personalInformation=new PersonalInformation(-1,name,middleNme,lastName,passportId);
        User user = new User(-1,login, password);
        user.setPersonalInformation(personalInformation);
        Request request1 = new Request(faculty, score1 + score2 + score3 + score4);

        if (!InformationDaoService.userInfExist(user) & !UserDaoService.userExist(user)) {
            if (informationDao.create(personalInformation) & userDao.create(user)) {
                request1.setUserId(userDao.findUserId(user));
                if (requestDao.create(request1)) {
                    final HttpSession session = request.createSession();
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("role", 2);
                } else {
                    informationDao.delete(user.getPersonalInformation().getId());
                    userDao.delete(user.getId());
                }
            } else {
                informationDao.delete(user.getPersonalInformation().getId());
            }
        }
        return COMMAND_RESPONSE;
    }
}

