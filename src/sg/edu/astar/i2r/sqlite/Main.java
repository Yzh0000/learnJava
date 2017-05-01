package sg.edu.astar.i2r.sqlite;

import java.sql.*;
/**
 * Created by Yzh on 5/1/2017.
 */
public class Main {
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {
        //String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
        String url = "jdbc:sqlite:db/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create a new table in the test database
     */
    public static void createNewTable() {
        //SQLite connection string
        String url = "jdbc:sqlite:db/test3.db";

        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouse (\n" +
                " id integer PRIMARY KEY, \n" +
                " name text NOT NULL, \n" +
                " capacity real\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            //create a new table
            stmt.execute(sql);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
//        createNewDatabase("test3.db");
        createNewTable();
    }
}
