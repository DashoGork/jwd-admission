package com.jwd_admission.byokrut.commandController;

public interface Command {
    CommandResponse execute(CommandRequest request);

    static Command of(String commandName) {
        return CommandInstance.commandOf(commandName);
    }
}
