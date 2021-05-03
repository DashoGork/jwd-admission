package com.jwd_admission.byokrut.commandController;

import javax.servlet.http.HttpSession;

public interface CommandRequest extends Command{
    Object getAttribute(String name);
    Object getRequestParameter(String name);
    HttpSession createSession();
    void setAttribute(String name,Object object);
}
