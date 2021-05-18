package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;
import static com.jwd_admission.byokrut.controller.pagesController.MainServlet.COMMAND;

public class LanguageChangeCommand implements Command {

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
        String commandName = request.getParameter(COMMAND);
        String pattern = "(id=\\w+)";
        Pattern.compile(pattern).matcher(commandName).find();
        Matcher matcher = Pattern.compile(pattern).matcher(commandName);
        String languageId = (matcher.find() ? matcher.group().substring(3) : "ru");
        request.createSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", languageId);
        return COMMAND_RESPONSE;
    }
}
