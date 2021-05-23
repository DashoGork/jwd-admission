package com.jwd_admission.byokrut.newDao;

import com.jwd_admission.byokrut.entity.BaseEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDao<K, T extends BaseEntity> {
    protected Connection connection;

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    public abstract T findEntityById(K id);
    public abstract List<T> findAll();
    public abstract boolean delete(K id);
    public abstract boolean create(T t);
    public abstract T update(T t);
    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
        }
    }
}
