package com.jwd_admission.byokrut.dao.impl.services;

import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.entity.User;

public class InformationDaoImplService {
    private InformationDaoImplService() {}
    private static InformationDaoImpl informationDao = new InformationDaoImpl();

    public static boolean userInfExist(User user) {
        return (informationDao.findUserInformationIdByPassportId(user.getPassportId()) != -1);
    }
}
