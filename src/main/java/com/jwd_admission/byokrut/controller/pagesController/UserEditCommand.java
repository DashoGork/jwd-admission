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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.ServiceDestination.PERSONAL_ACCOUNT_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;

public class UserEditCommand implements Command {
    InformationDaoImpl informationDao=new InformationDaoImpl();
    UserDaoImpl userDao=new UserDaoImpl();
    RequestDaoImpl requestDao=new RequestDaoImpl();

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
        int id= Integer.parseInt((String) request.getRequestParameter("id"));
        String name=request.getParameter("name");
        String middleNme=request.getParameter("middleName");
        String lastName=request.getParameter("lastName");
        String score_1=request.getParameter("score_1");
        String score_2=request.getParameter("score_2");
        String score_3=request.getParameter("score_3");
        String score_4=request.getParameter("score_4");
        String faculty=request.getParameter("faculty");
        String passport_id=request.getParameter("passport_id");
        User user= userDao.findEntityById(id);
        user.setPassportId(passport_id);
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setMiddleName(middleNme);
        user.setPassword(password);
        Request request1= new Request(Integer.parseInt(faculty),id,(Integer.parseInt(score_1)+(Integer.parseInt(score_2)+
                (Integer.parseInt(score_3)+(Integer.parseInt(score_4))))));
        informationDao.update(user);
        userDao.updateUser(user);
        ///ex
        requestDao.update(request1);


        return COMMAND_RESPONSE;
    }
}
