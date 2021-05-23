package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.dao.InformationDao;
import com.jwd_admission.byokrut.dao.RequestDao;
import com.jwd_admission.byokrut.dao.UserDao;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;
import static com.jwd_admission.byokrut.controller.ServiceDestination.EDIT_PAGE;

public class ShowEditPageCommand implements Command {
    private static Connection connection= ConnectionPool.INSTANCE.getConnection();
    private static UserDao userDao=new UserDao(connection);
    private static InformationDao informationDao=new InformationDao(connection);
    private static RequestDao requestDao=new RequestDao(connection);

    @Override
    public CommandResponse execute(CommandRequest request) {

        String commandName = request.getParameter(COMMAND);
        String pattern = "(id=\\d+)";
        Pattern.compile(pattern).matcher(commandName).find();
        Matcher matcher = Pattern.compile(pattern).matcher(commandName);
        if (matcher.find()) {
            int id = Integer.parseInt(matcher.group().substring(3));
            User user = userDao.findEntityById(id);
            user.setPersonalInformation(informationDao.findEntityById(user.getPersonalInformation().getId()));
            Request userRequest = requestDao.findRequestByUser(user.getId());
            request.setAttribute("req", userRequest);
            request.setAttribute("user", user);
            return () -> EDIT_PAGE;
        }

        return () -> MAIN_PAGE;
    }
}
