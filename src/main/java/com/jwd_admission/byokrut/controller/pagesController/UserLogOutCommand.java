package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;

import javax.servlet.http.HttpSession;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class UserLogOutCommand implements Command {
    @Override
    public CommandResponse execute(CommandRequest request) {
        final HttpSession session = request.createSession();
        session.removeAttribute("login");
        session.removeAttribute("role");
        return () -> MAIN_PAGE;
    }
}
