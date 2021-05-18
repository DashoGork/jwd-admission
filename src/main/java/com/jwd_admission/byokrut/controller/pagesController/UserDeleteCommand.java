package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;

public class UserDeleteCommand implements Command {
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
        informationDao.delete(user.getInfId());

        return COMMAND_RESPONSE;
    }
}
