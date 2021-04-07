package com.jwd_admission.byokrut.database.dao;

import com.jwd_admission.byokrut.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao <K,T extends Entity> {
    T findEntityById(K id);
    List<T> findAll();
    boolean delete(T t);
    boolean delete(K id);
    boolean create(T t);
    T update(T t);
    default void close(Statement statement){
        try{
            if(statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            //
        }
    }

    default void close(Connection connection){
        try{
            if(connection!=null){
                //return to pool!!

                connection.close();
            }
        }catch (SQLException e){
            //
        }
    }
}
