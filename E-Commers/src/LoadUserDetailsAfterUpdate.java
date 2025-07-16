import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadUserDetailsAfterUpdate {
    public static void UpdatingUserDetailsAfterUpdateEMail(String UserId) {
        Connection conn = H2DatabaseConnection.getConnection();

        String sql = "Select * FROM userDetails WHERE userId = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, UserId);

            ResultSet rs = ps.executeQuery();

            User user = new User();

            while (rs.next()) {
                user.setUserId(rs.getString("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("mailId"));
                user.setPassword(rs.getString("password"));

            }

            SessionManager.setCurrectUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdatingUserDetailsAfterUpdateUserId(String Email) {
        Connection conn = H2DatabaseConnection.getConnection();

        String sql = "Select * FROM userDetails WHERE mailId = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Email);

            ResultSet rs = ps.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setUserId(rs.getString("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("mailId"));
                user.setPassword(rs.getString("password"));
            }

            SessionManager.removeCurrectUser();
            SessionManager.setCurrectUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
