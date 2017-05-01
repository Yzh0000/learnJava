package sg.edu.astar.i2r.sqlite;

import java.sql.*;
/**
 * Created by Yzh on 5/1/2017.
 */
public class InsertApp {

    /**
     * Connect the the test database
     *
     * @return the Connection object
     *
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test3.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouse table
     *
     * @param name
     * @param capacity
     */

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouse(name, capacity) VALUES(?, ?)";

        try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }

}
