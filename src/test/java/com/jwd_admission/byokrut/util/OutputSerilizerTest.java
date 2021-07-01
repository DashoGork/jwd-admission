package com.jwd_admission.byokrut.util;

import com.jwd_admission.byokrut.entity.BaseEntity;
import com.jwd_admission.byokrut.entity.PersonalInformation;
import com.jwd_admission.byokrut.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputSerilizerTest {


    @Test
    void serializeWithPositiveRes() {
        String pathnameFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\test\\java\\com\\jwd_admission\\byokrut\\output\\test.ser";
        List<BaseEntity> testList=new ArrayList<>();
        testList.add(new User(1,"login","password"));
        testList.add(new User(3,new PersonalInformation(1,"Name","Surname","Lastname","PI")));
        boolean actual=OutputSerilizer.serialize(testList,pathnameFile);
        boolean expected=true;
        assertEquals(expected,actual);
    }

    @Test
    void serializeWithNegativeRes() {
        String pathnameFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\test\\java\\com\\jwd_admission\\byokrut\\output";
        List<BaseEntity> testList=new ArrayList<>();
        testList.add(new User(1,"login","password"));
        testList.add(new User(3,new PersonalInformation(1,"Name","Surname","Lastname","PI")));
        boolean actual=OutputSerilizer.serialize(testList,pathnameFile);
        boolean expected=false;
        assertEquals(expected,actual);
    }
}