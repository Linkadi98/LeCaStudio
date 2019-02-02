package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public Connection getConnect() {
        Connection connection = null;
        String url = "jdbc:mysql://85.10.205.173:3306/datapa02?autoReconnect=true&useSSL=false";
        String user = "thanhtuan02";
        String pwd = "Lovegsm4";
        try{
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Thanh cong");
        } catch (SQLException e) {
            // TODO:
            System.out.println("Unsucessful");

        }
        return connection;
    }
        //Testing connection between java and database
    public static void main(String[] args) {
        ConnectDB connectDB = new ConnectDB();
        connectDB.getConnect();

    }
}
