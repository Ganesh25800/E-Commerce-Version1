package ViewCart;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

public class PlaceTheOrder {

    public static boolean PlaceTheConfirmedOrder(List<List<String>> ConfirmedOrder) {

        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "INSERT INTO PlacedOrder (orderDate, categoryId, categoryName, subCategoryId, subCategoryName, " +
                "productId, productBrand, productPrice, productQuantity, productSize, " +
                "productAvailability, productGender, totalPrice, userId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int RowsAffected = 0;
        try{
            for (int i = 0; i < ConfirmedOrder.size(); i++) {

                List<String> confirmedOrderProduct = ConfirmedOrder.get(i);

                PreparedStatement ps = conn.prepareStatement(sql);

                String todayString = LocalDate.now().toString();
                ps.setString(1, todayString);

                ps.setString(2, confirmedOrderProduct.get(0));
                ps.setString(3, confirmedOrderProduct.get(1));
                ps.setString(4, confirmedOrderProduct.get(2));
                ps.setString(5, confirmedOrderProduct.get(3));
                ps.setString(6, confirmedOrderProduct.get(4));
                ps.setString(7, confirmedOrderProduct.get(5));
                ps.setString(8, confirmedOrderProduct.get(6));
                ps.setString(9, confirmedOrderProduct.get(7));
                ps.setString(10, confirmedOrderProduct.get(8));
                ps.setString(11, confirmedOrderProduct.get(9));
                ps.setString(12, confirmedOrderProduct.get(10));
                ps.setString(13, confirmedOrderProduct.get(11));
                ps.setString(14, UserCartProduct.UserEmail);

                RowsAffected++;

                ps.executeUpdate();

            }
        } catch(Exception e){
            System.out.println(e);
            System.out.println("\nError Occur, Placing Order\n");
            return false;
        }

        if(ConfirmedOrder.size() == RowsAffected){
            System.out.println("\nProducts Placed Successfully\n");
            boolean result = EmptyCartAfterPlacingOrder.EmptyCart();
            if(result) {
                return true;
            }
            else{
                System.out.println("\nError Occur, During Emptying Cart!\n");
            }
        }
        return false;
    }
}
