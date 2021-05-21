package com.jwd_admission.byokrut.dao.impl.services;

import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.User;

public class UserDaoImpService {
    private static UserDaoImpl userDao=new UserDaoImpl();

    public static boolean userExist(User user) {
        return (userDao.findUserId(user) != -1);
    }
}
