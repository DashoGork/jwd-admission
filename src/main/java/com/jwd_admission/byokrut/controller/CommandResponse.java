package com.jwd_admission.byokrut.controller;

@FunctionalInterface
public interface CommandResponse {
    default boolean isRedirect() {
        return false;
    }

    Destination getDestination();

}
