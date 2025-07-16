package ViewOrder;

import DatabaseConnection.H2DatabaseConnection;
import ViewCart.UserCartProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteOrderHistory {
    public static boolean ClearOrderHistory(String mail){
        try{
            Connection conn = H2DatabaseConnection.getConnection();
            String sql = "DELETE FROM PlacedOrder WHERE userId = ?";
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
