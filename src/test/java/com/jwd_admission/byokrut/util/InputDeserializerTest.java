package com.jwd_admission.byokrut.util;

import com.jwd_admission.byokrut.entity.BaseEntity;
import com.jwd_admission.byokrut.entity.FacultyName;
import com.jwd_admission.byokrut.entity.PersonalInformation;
import com.jwd_admission.byokrut.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputDeserializerTest {

    String pathnameFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\test\\java\\output\\passedMMF.ser";



    @Test
    void deserialize() {
        List<BaseEntity> expectedTestList=new ArrayList<>();
        User firstTestUser= new User(1,"login","password");
        User secondTestUser= new User(3,new PersonalInformation(1,"Name","Surname","Lastname","PI"));
        List<User> actualTestList= (List<User>) InputDeserializer.deserialize(pathnameFile);
        assertEquals(firstTestUser.getLogin().equals(actualTestList.get(1).getLogin()),true);
    }
}