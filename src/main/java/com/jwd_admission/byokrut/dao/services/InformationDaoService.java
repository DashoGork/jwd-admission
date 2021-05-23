package com.jwd_admission.byokrut.dao.services;

import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.dao.InformationDao;

import java.sql.Connection;

public class InformationDaoService {
    private static InformationDao informationDao;
    public InformationDaoService(Connection connection) {
        informationDao=new InformationDao(connection);
    }

    public static boolean userInfExist(User user) {
        return (informationDao.findIdByPassportId(user.getPersonalInformation().getPassportId()) != -1);
    }
}
