package com.jwd_admission.byokrut.controller;

import javax.servlet.http.HttpSession;

public interface CommandRequest extends Command {
    Object getRequestParameter(String name);
    HttpSession createSession();
    void setAttribute(String name, Object object);
    String getParameter(String command);
}
