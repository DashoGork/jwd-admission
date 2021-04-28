package com.jwd_admission.byokrut.entity;

import java.util.Objects;

public class Request extends Entity {
    private int id;
    private int facultyId;
    private int userId;
    private int score;
    private int approved = 0;

    public Request(int userId) {
        this.userId = userId;
    }

    public Request(int id, int facultyId, int userId, int score, int approved) {
        this.id = id;
        this.facultyId = facultyId;
        this.userId = userId;
        this.score = score;
        this.approved = approved;
    }

    public Request(int id, int facultyId, int score, int approved) {
        this.id = id;
        this.facultyId = facultyId;
        this.score = score;
        this.approved = approved;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getFacultyId() {
        return facultyId;
    }

    public int getApproved() {
        return approved;
    }

    public int getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id && facultyId == request.facultyId && userId == request.userId && score == request.score && approved == request.approved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyId, userId, score, approved);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", faculty_id=" + facultyId +
                ", user_id=" + userId +
                ", score=" + score +
                ", approved=" + approved +
                '}';
    }
}
