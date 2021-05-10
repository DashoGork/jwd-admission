package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.User;

public interface InformationDao extends BaseDao<Integer, User> {
    int findUserInformationIdByPassportId(User user);

    boolean userInfExist(User user);
}