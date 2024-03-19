package com.bookify.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class is responsible for managing the database connection.
 * It follows the Singleton design pattern to ensure only one instance exists.
 *
 * @author Ayon-SSP
 */
public class DBConnection {

    private static DBConnection dbConnection;
    private String url;
    private String username;
    private String password;
    private Connection connection;

    private DBConnection() {
        super();
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

            url = prop.getProperty("db.url");
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            synchronized (DBConnection.class) {
                if (dbConnection == null) {
                    dbConnection = new DBConnection();
                }
            }
        }

        return dbConnection;
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Connected");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}