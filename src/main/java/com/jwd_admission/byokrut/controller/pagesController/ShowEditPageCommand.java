package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;
import static com.jwd_admission.byokrut.controller.ServiceDestination.EDIT_PAGE;

public class ShowEditPageCommand implements Command {
    private UserDaoImpl userDao = new UserDaoImpl();
    private InformationDaoImpl informationDao = new InformationDaoImpl();
    private RequestDaoImpl requestDao = new RequestDaoImpl();

    @Override
    public CommandResponse execute(CommandRequest request) {

        String commandName = request.getParameter(COMMAND);
        String pattern = "(id=\\d+)";
        Pattern.compile(pattern).matcher(commandName).find();
        Matcher matcher = Pattern.compile(pattern).matcher(commandName);
        if (matcher.find()) {
            int id = Integer.parseInt(matcher.group().substring(3));
            User user = userDao.findEntityById(id);
            User.copyAllNotNullFields(user, informationDao.findEntityById(user.getInfId()));
            Request userRequest = requestDao.findRequestByUser(user.getId());
            request.setAttribute("req", userRequest);
            request.setAttribute("user", user);
            return () -> EDIT_PAGE;
        }

        return () -> MAIN_PAGE;
    }
}
