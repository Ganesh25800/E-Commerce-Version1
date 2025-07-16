package ViewOrder;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetUserOrdersFromDatabase {
    public static List<List<String>> returnUserOrders(String UserEmail){

        List<List<String>> userOrders = new ArrayList<>();

        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "SELECT * FROM PlacedOrder WHERE userId = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, UserEmail);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                List<String> orderDetails = new ArrayList<>();

                orderDetails.add(rs.getString("orderDate"));            
                orderDetails.add(rs.getString("categoryId"));              
                orderDetails.add(rs.getString("categoryName"));            
                orderDetails.add(rs.getString("subCategoryId"));           
                orderDetails.add(rs.getString("subCategoryName"));         
                orderDetails.add(rs.getString("productId"));               
                orderDetails.add(rs.getString("productBrand"));            
                orderDetails.add(rs.getString("productPrice"));            
                orderDetails.add(rs.getString("productQuantity"));         
                orderDetails.add(rs.getString("productSize"));             
                orderDetails.add(rs.getString("productAvailability"));     
                orderDetails.add(rs.getString("productGender"));           
                orderDetails.add(rs.getString("totalPrice"));              


                userOrders.add(orderDetails);
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("\nError occur, while getting the order details!\n");
            return null;
        }

        return userOrders;
    }
}
