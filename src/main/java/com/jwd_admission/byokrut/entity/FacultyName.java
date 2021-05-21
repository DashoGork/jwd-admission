package com.jwd_admission.byokrut.entity;

public enum FacultyName {
    MMF(1),
    RFIKT(2),
    FMO(3),
    BIO(4);

    private final int id;
    FacultyName(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
