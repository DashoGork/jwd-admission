package com.jwd_admission.byokrut.database.dao;

import com.jwd_admission.byokrut.entity.User;

public interface InformationDao extends BaseDao<Integer, User>{
    public int findUserInformationIdByPassportId(User user);
    public boolean UserInfExist(User user);
}
