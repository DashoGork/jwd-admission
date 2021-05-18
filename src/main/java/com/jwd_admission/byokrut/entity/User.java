package com.jwd_admission.byokrut.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;

public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private int roleId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String passportId;
    private int infId;

    public User() {
        super(-1);
    }

    public User(String firstName, String middleName, String lastName, String passportId, int infId) {
        super(-1);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.infId = infId;
    }

    public User(int id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, int infId) {
        super(id);
        this.login = login;
        this.password = password;
        this.infId = infId;
    }

    public User(int id, String login, String password, String firstName, String middleName, String lastName, String passportId) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public User(String login, String password, String firstName, String middleName, String lastName, String passportId) {
        super(-1);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public static void copyAllNotNullFields(User to, User from) {
        try {
            if (from.getId() != -1)
                to.setId(from.getId());
            for (Field field : from.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(from);
                if (null != value & !name.equals("serialVersionUID")) {
                    Field destField = to.getClass().getDeclaredField(name);
                    destField.setAccessible(true);
                    destField.set(to, value);
                    destField.setAccessible(false);
                }
                field.setAccessible(false);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Logger logger = LogManager.getLogger();
            logger.error(e);
        } ///what if error has happened before .setAccessible(false)?
    }

    @Override
    public int getId() {
        return super.getId();
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return roleId == user.roleId && infId == user.infId && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(middleName, user.middleName) && Objects.equals(lastName, user.lastName) && Objects.equals(passportId, user.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, roleId, firstName, middleName, lastName, passportId, infId);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportId='" + passportId + '\'' +
                ", infId=" + infId +
                '}';
    }
}

