package ViewCart;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmptyCartAfterPlacingOrder {

    public static boolean EmptyCart(){
        String mail = UserCartProduct.UserEmail;
        try{
            Connection conn = H2DatabaseConnection.getConnection();
            String sql = "DELETE FROM Cart WHERE userEmail = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,mail);
            int rows = ps.executeUpdate();

            if(rows > 0){
                return true;
            }

        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
