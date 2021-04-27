package com.jwd_admission.byokrut.entity;

import java.util.Objects;

public class Request extends Entity{
    private int id;
    private int faculty_id;
    private int user_id;
    private int score;
    private int approved=0;

    public Request(int user_id) {
        this.user_id = user_id;
    }

    public Request(int id, int faculty_id, int user_id, int score, int approved) {
        this.id = id;
        this.faculty_id = faculty_id;
        this.user_id = user_id;
        this.score = score;
        this.approved = approved;
    }

    public Request(int id, int faculty_id, int score, int approved) {
        this.id = id;
        this.faculty_id = faculty_id;
        this.score = score;
        this.approved = approved;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public int getApproved() {
        return approved;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id && faculty_id == request.faculty_id && user_id == request.user_id && score == request.score && approved == request.approved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty_id, user_id, score, approved);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", faculty_id=" + faculty_id +
                ", user_id=" + user_id +
                ", score=" + score +
                ", approved=" + approved +
                '}';
    }
}
