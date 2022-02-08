package com.erat.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {


    private static ConnectionPool instance;
    private static DataSource ds;

    private ConnectionPool(){

    }

    public static Connection getConnection() throws SQLException {
        Context context;
        Connection connection = null; //"jdbc:mysql://localhost:3306/cruise_company?user=admin&password=ItIsWednesday"
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/cruise_company");
            connection = ds.getConnection();
        } catch (NamingException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

}
