package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {



    public static Connection getConnection() throws SQLException {
        String dbName = "shop";
        String userName = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3308/"+dbName+"?useLegacyDatetimeCode=false&serverTimezone=America/New_York", userName, password);

        return connection;
    }

}
