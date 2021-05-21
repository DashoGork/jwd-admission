package com.jwd_admission.byokrut.dao.impl;

import com.jwd_admission.byokrut.connection.ConnectionPool;
import com.jwd_admission.byokrut.dao.InformationDao;
import com.jwd_admission.byokrut.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationDaoImpl implements InformationDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String nameField="name";
    private static final String middlenameField="middlename";
    private static final String lastnameField="lastname";
    private static final String passportIdField="passport_id";
    private static final String idField="id";

    private static final String SELECT_INFORMATION_ID_BY_PASSPORT_ID = "SELECT id FROM information WHERE passport_id=?;";
    private static final String CREATE_USER_INF = "INSERT INTO information (name, lastname," +
            "middlename, passport_id) VALUES (?,?,?,?);";
    private static final String SELECT_ALL_INF = "SELECT * FROM information";
    private static final String SELECT_INF_BY_ID = "SELECT * FROM information WHERE id=?";
    private static final String DELETE_USER_INF_BY_ID = "DELETE FROM information WHERE id=?;";
    private static final String UPDATE_USER_INF_BY_ID = "UPDATE information SET name=?,lastname=?,middlename=?, passport_id=?" +
            " WHERE id=?;";

    @Override
    public User findEntityById(Integer id) {
        User user = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INF_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();//!!
            String name = rs.getString(nameField);
            String middlename = rs.getString(middlenameField);
            String lastname = rs.getString(lastnameField);
            String passportId = rs.getString(passportIdField);
            int infId = rs.getInt(idField);
            user = new User(name, middlename, lastname, passportId, infId);
        } catch (SQLException e) {
            logger.error(e);
        }
        return user;
    }


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INF)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(nameField);
                String middlename = rs.getString(middlenameField);
                String lastname = rs.getString(lastnameField);
                String passportId = rs.getString(passportIdField);
                int infId = rs.getInt(idField);
                users.add(new User(name, middlename, lastname, passportId, infId));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return users;
    }


    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_INF_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public boolean create(User user) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE_USER_INF)) {
            preparedStatement1.setString(1, user.getFirstName());
            preparedStatement1.setString(2, user.getMiddleName());
            preparedStatement1.setString(3, user.getLastName());
            preparedStatement1.setString(4, user.getPassportId());
            preparedStatement1.executeUpdate();
            user.setInfId(findUserInformationIdByPassportId(user.getPassportId()));
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public User update(User user) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_USER_INF_BY_ID)) {
            preparedStatement1.setString(1, user.getFirstName());
            preparedStatement1.setString(2, user.getLastName());
            preparedStatement1.setString(3, user.getMiddleName());
            preparedStatement1.setString(4, user.getPassportId());
            preparedStatement1.setInt(5, user.getInfId());
            preparedStatement1.executeUpdate();
            user = (findEntityById(user.getInfId()));
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return user;
    }

    @Override
    public int findUserInformationIdByPassportId(String passportId) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFORMATION_ID_BY_PASSPORT_ID)) {
            preparedStatement.setString(1, passportId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            return ((resultSet.next()) ? resultSet.getInt(idField) : -1);
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return -1;
    }

}
