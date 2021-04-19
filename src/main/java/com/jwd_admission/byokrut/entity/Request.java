package com.jwd_admission.byokrut.entity;

public class Request extends Entity{
    private int id;
    private int faculty_id;
    private int user_id;
    private int score;

    public int getId() {
        return id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getScore() {
        return score;
    }

    public static class Builder {
        private Request request;

        public Builder() {
            request = new Request();
        }

        public Builder setId(int id) {
            request.id = id;
            return this;
        }

        public Builder setFacultyId(int id) {
            request.faculty_id = id;
            return this;
        }

        public Builder setUserId(int id) {
            request.user_id = id;
            return this;
        }

        public Builder setScore(int score) {
            request.score = score;
            return this;
        }

        public Request build() {
            return request;
        }
    }
}
