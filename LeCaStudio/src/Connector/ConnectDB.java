package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public Connection getConnect() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/qltv?autoReconnect=true&useSSL=false";
        String user = "root";
        String pwd = "1234";
        try{
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO:
            System.out.println("Unsucessful");

        }
        return connection;
    }
}
