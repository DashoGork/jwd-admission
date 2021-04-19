package com.jwd_admission.byokrut.database.dao.impl;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;
import com.jwd_admission.byokrut.database.dao.RequestDao;
import com.jwd_admission.byokrut.entity.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequestDaoImpl implements RequestDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String CREATE_REQUEST = "INSERT INTO request (score, user_id,faculty_id) VALUES(?,?,?);";
    private static final String APPROVE_REQUEST = "UPDATE request SET approved=1 where user_id=?;";


    @Override
    public Request findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public boolean delete(Request request) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Request request) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_REQUEST);){
            preparedStatement.setInt(1, request.getScore());
            preparedStatement.setInt(2, request.getUser_id());
            preparedStatement.setInt(3, request.getFaculty_id());
            int third = preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public Request update(Request request) {
        return null;
    }

    @Override
    public boolean Approve(Request request) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(APPROVE_REQUEST);) {
            preparedStatement.setInt(1, request.getUser_id());
            int result = preparedStatement.executeUpdate();
            if (result == 1) return true;
            return false;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }
}
