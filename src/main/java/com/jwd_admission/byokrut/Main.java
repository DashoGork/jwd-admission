package com.jwd_admission.byokrut;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.entity.Faculty;
import com.jwd_admission.byokrut.newDao.FacultyDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection= ConnectionPool.INSTANCE.getConnection();
        try {
            connection.setAutoCommit(false);
            FacultyDao facultyDaoNew=new FacultyDao(connection);
            Faculty faculty=facultyDaoNew.findEntityById(1);
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
            System.out.println(faculty);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}