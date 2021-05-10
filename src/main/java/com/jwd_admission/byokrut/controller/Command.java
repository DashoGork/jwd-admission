package com.jwd_admission.byokrut.controller;

public interface Command {
    CommandResponse execute(CommandRequest request);

    static Command of(String commandName) {
        return CommandInstance.commandOf(commandName);
    }
}
