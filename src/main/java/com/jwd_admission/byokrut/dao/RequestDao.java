package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.Request;

public interface RequestDao extends BaseDao<Integer, Request> {
    boolean approve(int UserId);
}
