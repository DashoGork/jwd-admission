package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.BaseEntity;
import java.util.List;

public interface BaseDao<K, T extends BaseEntity> {
    T findEntityById(K id);

    List<T> findAll();

    boolean delete(K id);

    boolean create(T t);

    T update(T t);
}
