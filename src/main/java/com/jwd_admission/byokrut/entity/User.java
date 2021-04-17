package com.jwd_admission.byokrut.entity;

public class User extends Entity {
    private int id;
    private String login;
    private String password;
    private int roleId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String passportId;
    private int infId;

    private User(){}

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPassportId() {
        return passportId;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getInfId() {
        return infId;
    }

    public static class Builder{
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder setId(int id){
            user.id=id;
            return this;
        }

        public Builder setLogin(String login){
            user.login=login;
            return this;
        }

        public Builder setPassword(String password){
            user.password=password;
            return this;
        }

        public Builder setRoleId(int id){
            user.roleId=id;
            return this;
        }

        public Builder setFirstName(String name){
            user.firstName=name;
            return this;
        }

        public Builder setMiddleName(String middleName){
            user.middleName=middleName;
            return this;
        }

        public Builder setLastName(String lastName){
            user.lastName=lastName;
            return this;
        }

        public Builder setPassportId(String passportId){
            user.passportId=passportId;
            return this;
        }

        public User build(){
            return user;
        }

        public Builder setInfId(int id){
            user.infId=id;
            return this;
        }
    }
}
