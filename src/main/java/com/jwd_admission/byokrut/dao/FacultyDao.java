package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.entity.Faculty;

import java.util.List;

public interface FacultyDao extends BaseDao<Integer, Faculty>{
    List<Faculty> selectAllFacultiesId();
}
