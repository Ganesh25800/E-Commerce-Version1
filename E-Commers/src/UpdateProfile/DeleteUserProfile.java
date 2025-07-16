package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteUserProfile {
    public static boolean DeleteUserProfileForever(String Email){
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "DELETE FROM userDetails WHERE mailId = ?;\n";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Email);

            int rows = ps.executeUpdate();

            if(rows > 0){
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
}
