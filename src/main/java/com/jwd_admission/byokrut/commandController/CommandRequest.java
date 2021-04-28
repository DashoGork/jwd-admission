package com.jwd_admission.byokrut.commandController;

import javax.servlet.http.HttpSession;

public interface CommandRequest extends Command{
    public Object getAttribute(String name);
    public Object getRequestParameter(String name);
    public HttpSession createSession();
}
