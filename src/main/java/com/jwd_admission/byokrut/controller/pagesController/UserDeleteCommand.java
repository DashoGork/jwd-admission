package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.dao.InformationDao;
import com.jwd_admission.byokrut.dao.RequestDao;
import com.jwd_admission.byokrut.dao.UserDao;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;

public class UserDeleteCommand implements Command {
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
        int id = -1;
        String idFromRequet;
        String commandName = request.getParameter(COMMAND);
        String pattern = "(id=\\d+)";
        Pattern.compile(pattern).matcher(commandName).find();
        Matcher matcher = Pattern.compile(pattern).matcher(commandName);
        if (matcher.find()) {
            idFromRequet = matcher.group();
            id = Integer.parseInt(idFromRequet.substring(3));
        }
        User user = userDao.findEntityById(id);
        requestDao.delete(id);
        userDao.delete(id);
        informationDao.delete(user.getPersonalInformation().getId());
        final HttpSession session = request.createSession();
        session.removeAttribute("login");
        session.removeAttribute("role");

        return COMMAND_RESPONSE;
    }
}
