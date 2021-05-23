package com.jwd_admission.byokrut.dao;

import com.jwd_admission.byokrut.connection.ProxyConnection;
import com.jwd_admission.byokrut.entity.Faculty;
import com.jwd_admission.byokrut.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FacultyDaoTest {

    private FacultyDao facultyDao;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @BeforeEach
    void setUp() {
        connection=mock(ProxyConnection.class);
        preparedStatement=mock(PreparedStatement.class);
        resultSet=mock(ResultSet.class);
        facultyDao=new FacultyDao(connection);
    }

    @Test
    void findEntityById() {


//            Connection connection=mock(ProxyConnection.class);
//            PreparedStatement preparedStatement=mock(PreparedStatement.class);
//            ResultSet resultSet=mock(ResultSet.class);
//            FacultyDao facultyDaoMock=mock(FacultyDao.class);
//            FacultyDao facultyDaoNew=new FacultyDao(connection);
//
//            ArrayList<Subject> subjects=new ArrayList<>();
//            subjects.add(new Subject(1,"name"));
//            subjects.add(new Subject(2,"name"));
//            subjects.add(new Subject(3,"name"));
//            when(connection.prepareStatement("SELECT * FROM faculty WHERE id=?")).thenReturn(preparedStatement);
//
//            when(facultyDaoNew.findSubjectInfo(1)).thenReturn(subjects);
//
//            given(preparedStatement.executeQuery()).willReturn(resultSet);
//
//            assertNotNull(resultSet);
//            given(resultSet.getString("name")).willReturn("ММФ");
//            given(resultSet.getInt("number_of_students")).willReturn(45);
//            Faculty faculty=facultyDaoNew.findEntityById(1);
//            Faculty faculty1=new Faculty(1,45,"ММФ");
//            assertEquals(faculty1,faculty);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    @Test
    void selectAllFacultiesId() {
        ArrayList<Faculty> expected=new ArrayList<>();
        expected.add(new Faculty(1));
        expected.add(new Faculty(2));
        try {
            when(connection.prepareStatement("SELECT * FROM faculty WHERE id=?")).thenReturn(preparedStatement);
            given(preparedStatement.executeQuery()).willReturn(resultSet);
            assertNotNull(resultSet);
            given(resultSet.getString("name")).willReturn("ММФ");
            given(resultSet.getInt("number_of_students")).willReturn(45);
            Faculty faculty=facultyDao.findEntityById(1);
            Faculty faculty1=new Faculty(1,45,"ММФ");
            assertEquals(faculty1,faculty);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}