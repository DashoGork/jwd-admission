package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.FacultyName;
import com.jwd_admission.byokrut.entity.Request;

import java.util.List;

public interface RequestDao extends BaseDao<Integer, Request> {
    boolean approve(int userId);
    List<Request> findAllPassed(FacultyName facultyName);
    List<Request> findAllPassedInAllFacultets();
    Request findRequestByUser(int userId);
}
