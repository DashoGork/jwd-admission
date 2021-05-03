package com.jwd_admission.byokrut.database.dao.impl;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;
import com.jwd_admission.byokrut.database.dao.FacultyDao;
import com.jwd_admission.byokrut.entity.Faculty;
import com.jwd_admission.byokrut.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDaoImpl implements FacultyDao {
    private static final Logger logger = LogManager.getLogger();

    private static final String SELECT_FACULTY_ID_BY_NAME = "SELECT id FROM faculty WHERE name=?;";

    private static final String SELECT_ALL_FACULTUES = "SELECT * FROM faculty";
    private static final String SELECT_FACULTY_BY_ID_FROM_FACULTY_SUB = "SELECT * FROM faculty_subject WHERE faculty_id=?";
    private static final String SELECT_FACULTY_BY_ID_FROM_FACULTY = "SELECT * FROM faculty WHERE id=?";



    private static final String DELETE_FACULTY_BY_ID = "DELETE FROM faculty WHERE id=?;";
    private static final String DELETE_FACULTY_BY_NAME = "DELETE FROM faculty WHERE name=?;";

    private static final String UPDATE_FACULTY_BY_ID = "UPDATE FROM faculty WHERE id=?;";



    @Override
    public Faculty findEntityById(Integer id) {
        Faculty faculty=new Faculty(id);
        faculty.setSubjectIds(findSubjectIdsFromFacultySubject(id));
        int iterator=0;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACULTY_BY_ID_FROM_FACULTY);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer number_of_students = rs.getInt("number_of_students");
                String name = rs.getString("name");
                faculty.setName(name);
                faculty.setNumberOfStudents(number_of_students);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return faculty;
    }

    private ArrayList<Integer> findSubjectIdsFromFacultySubject(Integer facultyId){
        ArrayList<Integer> subjectsId=new ArrayList<>(3);
        int iterator=0;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACULTY_BY_ID_FROM_FACULTY_SUB);) {
            preparedStatement.setInt(1, facultyId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer subjectId = rs.getInt("subject_id");
                subjectsId.add(subjectId);
                iterator++;
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return subjectsId;
    }

    @Override
    public List<Faculty> findAll() {
        List<Faculty> faculties = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACULTUES);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                faculties.add(findEntityById(id));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return faculties;
    }

    @Override
    public boolean delete(Faculty faculty) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Faculty faculty) {
        return false;
    }

    @Override
    public Faculty update(Faculty faculty) {
        return null;
    }
}
