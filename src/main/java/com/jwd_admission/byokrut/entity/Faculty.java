package com.jwd_admission.byokrut.entity;

import java.util.Objects;

public class Faculty extends BaseEntity {
    private int id;
    private int numberOfStudents;
    private String name;
    private int subjectId1;
    private int subjectId2;
    private int subjectId3;

    public Faculty(int id) {
        this.id = id;
    }

    public Faculty(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjectId1(int subjectId1) {
        this.subjectId1 = subjectId1;
    }

    public void setSubjectId2(int subjectId2) {
        this.subjectId2 = subjectId2;
    }

    public void setSubjectId3(int subjectId3) {
        this.subjectId3 = subjectId3;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public int getSubjectId1() {
        return subjectId1;
    }

    public int getSubjectId2() {
        return subjectId2;
    }

    public int getSubjectId3() {
        return subjectId3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && numberOfStudents == faculty.numberOfStudents && subjectId1 == faculty.subjectId1 && subjectId2 == faculty.subjectId2 && subjectId3 == faculty.subjectId3 && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfStudents, name, subjectId1, subjectId2, subjectId3);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", numberOfStudents=" + numberOfStudents +
                ", name='" + name + '\'' +
                ", subjectId1=" + subjectId1 +
                ", subjectId2=" + subjectId2 +
                ", subjectId3=" + subjectId3 +
                '}';
    }
}
