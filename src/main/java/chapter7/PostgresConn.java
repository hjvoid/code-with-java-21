package chapter7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConn {
    private Connection conn;

    public PostgresConn(String url, String username, String password) {
        connectToPostGres(url, username, password);
    }

    public void closePostgresConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void connectToPostGres(String url, String username, String password) {

        try {
            //connect to database
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
