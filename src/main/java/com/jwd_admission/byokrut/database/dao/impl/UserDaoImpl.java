package com.jwd_admission.byokrut.database.dao.impl;

import com.jwd_admission.byokrut.database.dao.UserDao;
import com.jwd_admission.byokrut.entity.User;

import java.util.List;

public class UserDaoImpl  implements UserDao {

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
