package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.newDao.UserDao;

import javax.servlet.http.HttpSession;

import java.sql.Connection;

import static com.jwd_admission.byokrut.controller.ServiceDestination.*;

public class UserLoginCommand implements Command {
    private static Connection connection = ConnectionPool.INSTANCE.getConnection();
    private static UserDao userDao = new UserDao(connection);


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
