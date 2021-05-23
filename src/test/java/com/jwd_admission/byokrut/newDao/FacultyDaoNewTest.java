package com.jwd_admission.byokrut.newDao;

import com.jwd_admission.byokrut.connection.ProxyConnection;
import com.jwd_admission.byokrut.entity.Faculty;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FacultyDaoNewTest {


    @Test
    void findEntityById() {

        try {
            Connection connection=mock(ProxyConnection.class);
            PreparedStatement preparedStatement=mock(PreparedStatement.class);
            ResultSet resultSet=mock(ResultSet.class);
            FacultyDao facultyDaoNew=new FacultyDao(connection);

            when(connection.prepareStatement("SELECT * FROM faculty WHERE id=?")).thenReturn(preparedStatement);
            given(preparedStatement.executeQuery()).willReturn(resultSet);
            assertNotNull(resultSet);
            given(resultSet.getString("name")).willReturn("ММФ");
            given(resultSet.getInt("number_of_students")).willReturn(45);
            Faculty faculty=facultyDaoNew.findEntityById(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}