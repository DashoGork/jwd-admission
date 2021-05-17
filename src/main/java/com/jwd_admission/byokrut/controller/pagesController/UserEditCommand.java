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


import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class UserEditCommand implements Command {
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

        String password = (String) request.getRequestParameter("password");
        int id = Integer.parseInt((String) request.getRequestParameter("id"));
        String name = request.getParameter("name");
        String middleNme = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String score1 = request.getParameter("score_1");
        String score2 = request.getParameter("score_2");
        String score3 = request.getParameter("score_3");
        String score4 = request.getParameter("score_4");
        String faculty = request.getParameter("faculty");
        String passportId = request.getParameter("passport_id");
        User user = userDao.findEntityById(id);
        user.setPassportId(passportId);
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setMiddleName(middleNme);
        user.setPassword(password);
        Request request1 = new Request(Integer.parseInt(faculty), id, (Integer.parseInt(score1) + (Integer.parseInt(score2) +
                (Integer.parseInt(score3) + (Integer.parseInt(score4))))));
        informationDao.update(user);
        userDao.updateUser(user);
        ///ex
        requestDao.update(request1);


        return COMMAND_RESPONSE;
    }
}
