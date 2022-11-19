package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        Connection connection = null;

        String url = "jdbc:sqlite::resource:crudAV2.db";


        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
