package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckingNewUserEmailInDatabase {
    public static boolean CheckUserNewEmailInDatabase(String email) {
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "SELECT * FROM userDetails WHERE mailId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            boolean exist = rs.next();

            if (exist) {
                return false;
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;

    }
}
