package com.jwd_admission.byokrut.database.dao;

import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

public interface RequestDao extends BaseDao<Integer, Request> {
    boolean approve(Request request);
}
