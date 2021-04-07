package com.jwd_admission.byokrut.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private ConnectionPool connectionPool;
    private BlockingQueue<ProxyConnectionPool> freeConnections;
    private Queue<ProxyConnectionPool> givenAwayConnections;

    private final static int DEFAULT_POOL_SIZE=32;

    {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        freeConnections=new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections=new ArrayDeque<>();

        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                System.out.println('1');
                freeConnections.add(new ProxyConnectionPool(DriverManager.getConnection("jdbc:mysql://localhost:3306/admission_prefinal?" +
                                "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        "root","5tHyu3a90Jh_q")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public Connection getConnection(){
        ProxyConnectionPool connection=null;

        try {
            connection=freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection){
        if(connection.getClass().equals(ProxyConnectionPool.class)){
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnectionPool) connection);//ebanytsa
        }
        else try { ///pizdets
            throw new SQLException();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void destroyPool(){
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        deregisterDrivers();
    }

    private void deregisterDrivers(){
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

}
