package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.User;

public interface UserDao extends BaseDao<Integer, User> {
    User findUserByInfId(Integer infId);
    int findUserId(User user);
    int findUserByLoginAndPassword(User user);
    int findUserRoleId(User user);
    boolean userExist(User user);
}

