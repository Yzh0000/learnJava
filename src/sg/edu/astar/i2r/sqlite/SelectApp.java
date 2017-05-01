package sg.edu.astar.i2r.sqlite;

import java.sql.*;
/**
 * Created by Yzh on 5/1/2017.
 */
public class SelectApp {
    /**
     * Connect to the test databse
     * @return the Connection object
     */
    private Connection connect() {
        //SQLite connection string
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
     * select all rows in the warehouse table
     */
    public void selectAll() {
        String sql = "SELECT id, name, capacity FROM warehouse";

        try (Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            //loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("name") + "\t" +
                rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Get the warehouse whose capacity greater than a specified capacity
     * @param capacity
     */
    public void getCapacityGreaterThan(double capacity) {
        String sql = "SELECT id, name, capacity " +
                "FROM warehouse WHERE capacity > ?";

        try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set the value
            pstmt.setDouble(1, capacity);
            //
            ResultSet rs = pstmt.executeQuery();

            //loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
//        app.selectAll();

        app.getCapacityGreaterThan(3600);
    }
}
