package com.jwd_admission.byokrut.controller;

import com.jwd_admission.byokrut.controller.pagesController.*;

public enum CommandInstance {
    SHOW_MAIN(new ShowMainPageCommand()),
    SHOW_REGISTRATION(new ShowRegistrationPage()),
    REGISTRATION(new UserRegistrationCommand()),
    SHOW_LOGIN(new ShowLoginPageCommand()),
    LOGIN(new UserLoginCommand()),
    SHOW_PERSONAL_ACCOUNT(new ShowPersonalAccountCommand()),
    SHOW_EDIT(new ShowEditPageCommand()),
    EDIT(new UserEditCommand()),
    APPROVE(new UserApproveCommand()),
    DELETE(new UserDeleteCommand()),
    CALCULATE(new AdminCalculateCommand());

    private final Command command;

    CommandInstance(Command command) {
        this.command = command;
    }

    static Command commandOf(String commandName) {
        for (CommandInstance value : values()) {
            if (value.name().equalsIgnoreCase(commandName)) {
                return value.command;
            }
        }
        return SHOW_MAIN.command;
    }
}
