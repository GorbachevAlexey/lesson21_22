package ru.sbt.java.school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbsCacheDAO {
    private static final String LOGIN = "sa";
    private static final String PASS = null;
    public static final String URL = "jdbc:h2:file:~/cache.db";

    protected Connection getConnection(String url){
        try{
            return DriverManager.getConnection(url,LOGIN,PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Can't load driver",e);
        }
    }
}
