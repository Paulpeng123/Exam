package com.ivan.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
        private static String forName=null;
        private static String url=null;
        private static String username=null;
        private static String password=null;

    /*static {
        Properties properties = new Properties();
        try {          为什么不能加String在forName..前
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String forName = properties.getProperty("forName");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    static{
        Properties properties = new Properties();
        try {                                                       //注意是"getClassLoader()"
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            forName=properties.getProperty("forName");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName(forName);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }*/
    return conn;
    }


}
