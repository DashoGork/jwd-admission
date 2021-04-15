package com.jwd_admission.byokrut.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ConnectionPool {
    INSTANCE;

    private static final Logger logger = LogManager.getLogger();
    private ConnectionPool connectionPool;
    private BlockingQueue<ProxyConnectionPool> freeConnections;
    private Queue<ProxyConnectionPool> givenAwayConnections;

    private final static int DEFAULT_POOL_SIZE=32;

    {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException throwables) {
            LogManager.getLogger().error(throwables);
        }

        freeConnections=new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections=new ArrayDeque<>();

        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.add(new ProxyConnectionPool(DriverManager.getConnection("jdbc:mysql://localhost:3306/admission?" +
                                "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        "root","5tHyu3a90Jh_q")));
            } catch (SQLException throwables) {
                LogManager.getLogger().error(throwables);
            }
        }
    }


    public Connection getConnection(){
        ProxyConnectionPool connection=null;
        try {
            connection=freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            logger.error(e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection){
        if(connection.getClass().equals(ProxyConnectionPool.class)){
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnectionPool) connection);
        }
        else try {
            throw new SQLException();
        } catch (SQLException throwables) {
            logger.error(throwables);
        }
    }

    public void destroyPool(){
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException throwables) {
                logger.error(throwables);
            } catch (InterruptedException e) {
                logger.error(e);
            }

        }
        deregisterDrivers();
    }

    private void deregisterDrivers(){
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException throwables) {
                logger.error(throwables);
            }
        });
    }

}
