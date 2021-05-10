package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.PERSONAL_ACCOUNT_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;

public class UserApproveCommand implements Command {
    RequestDaoImpl requestDao = new RequestDaoImpl();

    public static final CommandResponse COMMAND_RESPONSE = new CommandResponse() {
        @Override
        public boolean isRedirect() {
            return false;
        }

        @Override
        public Destination getDestination() {
            return PERSONAL_ACCOUNT_PAGE;
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
            System.out.println(id);
        }
        requestDao.approve(id);
        return COMMAND_RESPONSE;


    }
}
