package com.jwd_admission.byokrut.newDao.services;


import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.newDao.UserDao;

import java.sql.Connection;

public class UserDaoService {
    private static UserDao userDao;

    public UserDaoService(Connection connection) {
        userDao=new UserDao(connection);
    }

    public static boolean userExist(User user) {
        return (userDao.findUserId(user) != -1);
    }
}
