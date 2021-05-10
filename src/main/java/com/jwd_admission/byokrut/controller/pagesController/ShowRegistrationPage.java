package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;

import static com.jwd_admission.byokrut.controller.ServiceDestination.REGISTRATION_PAGE;

public class ShowRegistrationPage implements Command {
    @Override
    public CommandResponse execute(CommandRequest request) {
        return () -> REGISTRATION_PAGE;
    }
}
