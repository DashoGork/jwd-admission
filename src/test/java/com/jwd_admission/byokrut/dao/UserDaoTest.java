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