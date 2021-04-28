package com.jwd_admission.byokrut.commandController;

public interface Command {
    CommandResponsr execute(CommandRequest request);
    static Command of(String commandName){
        return CommandInstance.commandOf(commandName);
    }
}
