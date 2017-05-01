package sg.edu.astar.i2r.sqlite;

import java.sql.*;
/**
 * Created by Yzh on 5/1/2017.
 */
public class SQLiteJDBCDriverConnection {
    /**
     * Connect to a sample database
     */

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:test2.db"; // eg2: "jsbc"sqlite:C:/sqlite/db/chinook.db"
            //create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}

