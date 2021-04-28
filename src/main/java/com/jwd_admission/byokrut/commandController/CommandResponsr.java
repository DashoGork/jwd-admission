package com.jwd_admission.byokrut.commandController;

import javax.servlet.http.HttpSession;

@FunctionalInterface
public interface CommandResponsr {
    default boolean isRedirect(){return false;}
    Destination getDestination();

}
