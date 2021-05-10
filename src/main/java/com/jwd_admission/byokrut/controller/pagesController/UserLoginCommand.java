package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;

import static com.jwd_admission.byokrut.controller.ServiceDestination.*;

public class UserLoginCommand implements Command {
    UserDaoImpl userDao = new UserDaoImpl();


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
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        if (userDao.findUserByLoginAndPassword(user) != -1) {
            user.setRoleId(userDao.findUserRoleId(user));
            final HttpSession session = request.createSession();
            session.setAttribute("login", user.getLogin());
            session.setAttribute("role", user.getRoleId());
        }
        return COMMAND_RESPONSE;
    }
}
