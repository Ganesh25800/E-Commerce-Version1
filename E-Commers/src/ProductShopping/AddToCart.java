package ProductShopping;

import DatabaseConnection.H2DatabaseConnection;
import ProductShopping.FileClasses.ProductClass;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddToCart {
    public static boolean AddProductToCart(String CategoryID, String CategoryName, String SubProductID, String SubProductName,
                                           ProductClass productClass, int Quantity, double TotalPrice) {

        Connection conn = H2DatabaseConnection.getConnection();
        String mail = ProductShoppingCategory.UserMail;
        try{
            String sql = "INSERT INTO Cart (" +
                    "categoryId, categoryName, subCategoryId, subCategoryName, " +
                    "productId, productBrand, productPrice, productQuantity, " +
                    "productSize, productAvailability, productGender, totalPrice,userEmail) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ProductClass product = productClass;

            ps.setString(1, CategoryID);
            ps.setString(2, CategoryName);
            ps.setString(3, SubProductID);
            ps.setString(4, SubProductName);
            ps.setString(5, product.getProductID());
            ps.setString(6, product.getProductName());
            ps.setString(7, product.getProductPrice());
            ps.setString(8, String.valueOf(Quantity));
            ps.setString(9, product.getProductSize());
            ps.setString(10, product.getProductAvailability());
            ps.setString(11, product.getGender());
            ps.setString(12, String.valueOf(TotalPrice));
            ps.setString(13,mail);

            int row = ps.executeUpdate();

            return row > 0;

        } catch(Exception e){
            System.out.println("\nError in AddProductToCart");
            return false;
        }

    }
}
