package com.jwd_admission.byokrut.commandController;

import static com.jwd_admission.byokrut.commandController.ServiceDestination.MAIN_PAGE;

public class ShowMainPageCommand implements Command{

    @Override
    public CommandResponsr execute(CommandRequest request){

        return()->MAIN_PAGE;
    }


}
