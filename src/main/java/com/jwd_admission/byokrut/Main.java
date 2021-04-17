package com.jwd_admission.byokrut;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection= ConnectionPool.INSTANCE.getConnection();
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("ok");
    }}