package com.jwd_admission.byokrut.commandController;

public enum CommandInstance {
    SHOW_MAIN(new ShowMainPageCommand()),
    SHOW_LOGIN(new ShowLoginPageCommand()),
    SHOW_PERSONAL_ACCOUNT(new ShowPersonalAccountCommand()),
    LOGIN(new UserLoginCommand());

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
