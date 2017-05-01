package sg.edu.astar.i2r.sqlite;

import java.sql.*;
/**
 * Created by Yzh on 5/1/2017.
 */
public class DeleteApp {
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
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
     * Delete a warehouse specified by the id
     *
     * @param id
     */

    public void delete(int id) {
        String sql = "DELETE FROM warehouse WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set the corresponding param
            pstmt.setInt(1, id);
            //execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DeleteApp app = new DeleteApp();
        // delete the row with id 3
        app.delete(6);
    }

}
