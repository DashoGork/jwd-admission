package com.jwd_admission.byokrut.database.dao.impl;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;
import com.jwd_admission.byokrut.database.dao.UserDao;
import com.jwd_admission.byokrut.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl  implements UserDao {
    private static final Logger logger = LogManager.getLogger();
    //private Connection connection= ConnectionPool.INSTANCE.getConnection();

    private static final String SELECT_INFORMATION_ID_BY_PASSPORT_ID="SELECT id FROM information WHERE passport_id=?;";
    private static final String SELECT_USER_ID_BY_LOGIN="SELECT id FROM user WHERE login=? ;";

    private static final String CREATE_USER_INF="INSERT INTO information (name, lastname," +
            "middlename, passport_id) VALUES (?,?,?,?);";
    private static final String CREATE_USER = "INSERT INTO user" +
            "  (login, password, information_id) VALUES " +
            " (?, ?,?);";
    //private static String CREATE_REQUEST="INSERT INTO request (score, user_id,faculty_id) VALUES(?,?,?);";

    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD="SELECT id FROM user WHERE login=? AND password=?;";
    private static final String SELECT_USER_BY_ID="SELECT * FROM user WHERE id=?;";
    private static final String UPDATE_USER_BY_ID = "update user set login = ?, password= ?  where id = ?;";

    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String SELECT_ALL_INF = "select * from information";
    private static final String SELECT_ALL_INF_BY_ID = "select * from information where id=?";

    private static final String DELETE_USER="DELETE FROM user WHERE login=?;";
    private static final String DELETE_USER_INF="DELETE FROM information WHERE passport_id=?;";

    private static final String SELECT_USER_ROLE_ID="SELECT role_id FROM user WHERE login=? AND password=?;";


    @Override
    public User findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findUserByLastName(String stringpattern) {
        return null;
    }
}
