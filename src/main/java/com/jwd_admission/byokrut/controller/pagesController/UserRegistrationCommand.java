package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.dao.impl.services.InformationDaoImplService;
import com.jwd_admission.byokrut.dao.impl.services.UserDaoImpService;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class UserRegistrationCommand implements Command {
    InformationDaoImpl informationDao = new InformationDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();
    RequestDaoImpl requestDao = new RequestDaoImpl();

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

        User user = new User(login, password, name, middleNme, lastName, passportId);
        Request request1 = new Request(faculty, score1 + score2 + score3 + score4);

        if (!InformationDaoImplService.userInfExist(user) & !UserDaoImpService.userExist(user)) {
            if (informationDao.create(user) & userDao.create(user)) {
                request1.setUserId(userDao.findUserId(user));
                if (requestDao.create(request1)) {
                    final HttpSession session = request.createSession();
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("role", 2);
                } else {
                    informationDao.delete(user.getInfId());
                    userDao.delete(user.getId());
                }
            } else {
                informationDao.delete(user.getInfId());
            }
        }
        return COMMAND_RESPONSE;
    }
}

