package com.jwd_admission.byokrut.commandController;

import static com.jwd_admission.byokrut.commandController.ServiceDestination.LOGIN_PAGE;

public class ShowLoginPageCommand implements Command{

    @Override
    public CommandResponse execute(CommandRequest request) {
        return()->LOGIN_PAGE;
    }
}
