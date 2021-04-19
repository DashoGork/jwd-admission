package com.jwd_admission.byokrut;

import com.jwd_admission.byokrut.database.connection.ConnectionPool;
import com.jwd_admission.byokrut.util.PropertyReaderUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println(PropertyReaderUtil.getLogin());
    }}