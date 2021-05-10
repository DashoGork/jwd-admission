package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
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
        String login = (String) request.getRequestParameter("login");
        String password = (String) request.getRequestParameter("password");
        String name = request.getParameter("name");
        String middleNme = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String score_1 = request.getParameter("score_1");
        String score_2 = request.getParameter("score_2");
        String score_3 = request.getParameter("score_3");
        String score_4 = request.getParameter("score_4");
        String faculty = request.getParameter("faculty");
        String passport_id = request.getParameter("passport_id");

        User user = new User(login, password, name, middleNme, lastName, passport_id);
        Request request1 = new Request(Integer.parseInt(faculty), (Integer.parseInt(score_1) + (Integer.parseInt(score_2) +
                (Integer.parseInt(score_3) + (Integer.parseInt(score_4))))));

        if (!informationDao.userInfExist(user) & !userDao.userExist(user)) {
            if (informationDao.create(user)) {
                if (userDao.create(user)) {
                    request1.setUserId(userDao.findUserId(user));
                    if (requestDao.create(request1)) {
                        final HttpSession session = request.createSession();
                        session.setAttribute("login", user.getLogin());
                        session.setAttribute("role", 2);

                    } else {
                        informationDao.delete(user);
                        userDao.delete(user);
                        //errorpage
                    }
                } else {
                    informationDao.delete(user);

                }
            } else {

            }
        } else {

        }
        return COMMAND_RESPONSE;
    }
}

