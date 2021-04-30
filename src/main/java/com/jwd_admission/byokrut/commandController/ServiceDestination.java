package com.jwd_admission.byokrut.commandController;

public enum

ServiceDestination implements Destination{
    MAIN_PAGE("/WEB-INF/jsp/main.jsp"),
    LOGIN_PAGE("/WEB-INF/jsp/signIn.jsp"),
    REGISTRATION_PAGE("/WEB-INF/jsp/signIn.jsp"),
    PERSONAL_ACCOUNT_PAGE("/WEB-INF/jsp/personalAccount.jsp"),
    ADMIN_PAGE("/WEB-INF/jsp/adminPersonalAccount.jsp"),
    EDIT_PAGE("/WEB-INF/jsp/edit.jsp"),
    INDEX("/");

    private final String path;
    private static final String BASE_URL="/WEB-INF/jsp";


    ServiceDestination(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }


}
