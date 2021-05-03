package com.jwd_admission.byokrut.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Faculty extends BaseEntity {
    private int id;
    private int numberOfStudents;
    private String name;
    private ArrayList<Integer> subjectIds;

    public Faculty(int id) {
        this.id = id;
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(int id, int numberOfStudents, String name) {
        this.id = id;
        this.numberOfStudents = numberOfStudents;
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
        this.subjectIds.set(0, subjectId1);
    }

    public void setSubjectId2(int subjectId2) {
        this.subjectIds.set(1, subjectId2);
    }

    public void setSubjectId3(int subjectId3) {

        this.subjectIds.set(2, subjectId3);
    }

    public void setSubjectIds(ArrayList<Integer> subjectIds) {
        this.subjectIds = subjectIds;
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
        return subjectIds.get(0);
    }

    public int getSubjectId2() {
        return subjectIds.get(1);
    }

    public int getSubjectId3() {
        return subjectIds.get(2);
    }

    public ArrayList<Integer> getSubjectIds() {
        return subjectIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && numberOfStudents == faculty.numberOfStudents && Objects.equals(name, faculty.name) && Objects.equals(subjectIds, faculty.subjectIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfStudents, name, subjectIds);
    }
}
