package com.jwd_admission.byokrut.database.dao.impl;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;
import com.jwd_admission.byokrut.database.dao.InformationDao;
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

    private static final String SELECT_INFORMATION_ID_BY_PASSPORT_ID="SELECT id FROM information WHERE passport_id=?;";

    private static final String CREATE_USER_INF="INSERT INTO information (name, lastname," +
            "middlename, passport_id) VALUES (?,?,?,?);";

    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD="SELECT id FROM user WHERE login=? AND password=?;";

    private static final String SELECT_ALL_INF = "select * from information";
    private static final String SELECT_INF_BY_ID = "select * from information where id=?";

    private static final String DELETE_USER_INF="DELETE FROM information WHERE passport_id=?;";
    private static final String DELETE_USER_INF_BY_ID="DELETE FROM information WHERE id=?;";

    private static final String UPDATE_USER_INF_BY_ID="UPDATE FROM information WHERE id=?;";

    @Override
    public User findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List < User > users = new ArrayList< >();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INF);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                    String name=rs.getString("name");
                    String middlename=rs.getString("middlename");
                    String lastname=rs.getString("lastname");
                    String passportId=rs.getString("passport_id");
                    Integer infId=rs.getInt("id");
                    users.add(new User.Builder().setFirstName(name).setInfId(infId)
                            .setMiddleName(middlename).setLastName(lastname).setPassportId(passportId).build());
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return users;
    }

    @Override
    public boolean delete(User user) {
        try(Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER_INF);) {
            preparedStatement.setString(1,user.getPassportId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER_INF_BY_ID);) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public boolean create(User user){
        try(Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement1=connection.prepareStatement(CREATE_USER_INF);){
            preparedStatement1.setString(1,user.getFirstName());
            preparedStatement1.setString(2,user.getMiddleName());
            preparedStatement1.setString(3,user.getLastName());
            preparedStatement1.setString(4,user.getPassportId());
            preparedStatement1.executeUpdate();
            user.setInfId(findUserInformationIdByPassportId(user));
            return true;
        }catch (SQLException throwables) {
            logger.error(throwables);
        }
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public int findUserInformationIdByPassportId(User user){
        try(Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_INFORMATION_ID_BY_PASSPORT_ID)) {
            preparedStatement.setString(1,user.getPassportId());
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getResultSet();
            if( resultSet.next()) return resultSet.getInt("id");
            else return -1;
        } catch (SQLException throwables) {
            logger.error(throwables);
            //throwables.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean UserInfExist(User user){
        if(findUserInformationIdByPassportId(user)!=-1) return true;
        else return false;
    }
}
