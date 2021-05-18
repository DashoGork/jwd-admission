package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.Request;

import java.util.List;

public interface RequestDao extends BaseDao<Integer, Request> {
    boolean approve(int userId);
    List<Request> findAllPassed(int facultyId);
    List<Request> findAllPassedInAllFacultets();
    Request findRequestByUser(int userId);
}
