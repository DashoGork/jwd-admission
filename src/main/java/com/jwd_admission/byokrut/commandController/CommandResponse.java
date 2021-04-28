package com.jwd_admission.byokrut.commandController;

@FunctionalInterface
public interface CommandResponse {
    default boolean isRedirect() {
        return false;
    }

    Destination getDestination();

}
