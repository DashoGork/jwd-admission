package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.connection.ProxyConnection;
import com.jwd_admission.byokrut.entity.PersonalInformation;
import com.jwd_admission.byokrut.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserDaoTest {

    private UserDao userDao;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = mock(ProxyConnection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        userDao = new UserDao(connection);
    }

    @Test
    void findEntityById() {
        try {
            User expectedUser = new User(1, "expectedLogin", "expectedPassword",new PersonalInformation(-1));
            when(connection.prepareStatement("SELECT * FROM user WHERE id=?;")).thenReturn(preparedStatement);
            given(preparedStatement.executeQuery()).willReturn(resultSet);
            assertNotNull(resultSet);
            given(resultSet.getString("login")).willReturn("expectedLogin");
            given(resultSet.getString("password")).willReturn("expectedPassword");
            User actualUser = userDao.findEntityById(1);
            assertEquals(expectedUser, actualUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findUserByInfId() {
        try {
            User expectedUser = new User(1, "expectedLogin", "expectedPassword",new PersonalInformation(1));
            when(connection.prepareStatement("SELECT * FROM user WHERE information_id=?;")).thenReturn(preparedStatement);
            given(preparedStatement.executeQuery()).willReturn(resultSet);
            assertNotNull(resultSet);
            given(resultSet.getString("login")).willReturn("expectedLogin");
            given(resultSet.getString("password")).willReturn("expectedPassword");
            User actualUser = userDao.findUserByInfId(1);
            assertEquals(expectedUser, actualUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll() {
        List<User> usersExpected = new ArrayList<>();
        usersExpected.add(new User(1,"login1","password1",new PersonalInformation(1)));
        usersExpected.add(new User(2,"login2","password2",new PersonalInformation(2)));
        try {
            when(connection.prepareStatement("select * from user")).thenReturn(preparedStatement);
            given(preparedStatement.executeQuery()).willReturn(resultSet);
            assertNotNull(preparedStatement);
            assertNotNull(resultSet);
            resultSet.setFetchSize(2);
            when(resultSet.next()).thenReturn(true);
            given(resultSet.getString("login")).willReturn("login1");
            given(resultSet.getString("password")).willReturn("password1");
            given(resultSet.getInt("id")).willReturn(1);
            given(resultSet.getInt("information_id")).willReturn(1);
            when(resultSet.next()).thenReturn(true);
            given(resultSet.getString("login")).willReturn("login2");
            given(resultSet.getString("password")).willReturn("password2");
            given(resultSet.getInt("id")).willReturn(2);
            given(resultSet.getInt("information_id")).willReturn(2);
            given(resultSet.next()).willReturn(false);

            List<User> usersActual = userDao.findAll();
            System.out.println(usersActual);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    void delete() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void findUserId() {
    }

    @Test
    void findUserByLoginAndPassword() {
    }

    @Test
    void findUserRoleId() {
    }
}