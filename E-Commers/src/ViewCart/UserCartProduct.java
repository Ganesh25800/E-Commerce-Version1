package ViewCart;

import DatabaseConnection.H2DatabaseConnection;
import ProductShopping.ProductShoppingCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserCartProduct {

    public static String UserEmail = "";

    public static void UserCartProductDisplay(String Email){

        UserEmail = Email;

        Connection con = H2DatabaseConnection.getConnection();
        String Mail = ProductShoppingCategory.UserMail;

        double TotalPrice = 0;

    while(true) {
        List<List<String>> products = new ArrayList<>();

        System.out.println("\n-----------------------------");
        System.out.println("          Your Cart          ");
        System.out.println("-----------------------------");
        try {
            String sql = "SELECT * FROM Cart WHERE userEmail = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Mail);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                List<String> CartDetails = new ArrayList<String>();

                String CategoryID = rs.getString("categoryId");
                String CategoryName = rs.getString("categoryName");
                String SubProductID = rs.getString("subCategoryId");
                String SubProductName = rs.getString("subCategoryName");
                String ProductID = rs.getString("productId");
                String ProductName = rs.getString("productBrand");
                String ProductPrice = rs.getString("productPrice");
                String ProductQuantity = rs.getString("productQuantity");
                String ProductSize = rs.getString("productSize");
                String ProductAvailable = rs.getString("productAvailability");
                String ProductGender = rs.getString("productGender");

                String ProductTotalPrice = rs.getString("totalPrice");
                double Price = Double.parseDouble(ProductTotalPrice);

                TotalPrice += Price;

                CartDetails.add(CategoryID);
                CartDetails.add(CategoryName);
                CartDetails.add(SubProductID);
                CartDetails.add(SubProductName);
                CartDetails.add(ProductID);
                CartDetails.add(ProductName);
                CartDetails.add(ProductPrice);
                CartDetails.add(ProductQuantity);
                CartDetails.add(ProductSize);
                CartDetails.add(ProductAvailable);
                CartDetails.add(ProductGender);
                CartDetails.add(ProductTotalPrice);

                products.add(CartDetails);
                count++;
                System.out.println(count + ".Category: " + CategoryName);
                System.out.println("  SubCategory: " + SubProductName);
                System.out.println("  Brand: " + ProductName);
                System.out.println("  Price: " + ProductPrice);
                System.out.println("  Quantity: " + ProductQuantity);
                System.out.println("  Size: " + ProductSize);
                System.out.println("  Available: " + ProductAvailable);
                System.out.println("  Gender: " + ProductGender);
                System.out.println("  Total Price: $" + ProductTotalPrice);
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error Occur, Getting the User Cart Product!");
            return;
        }

        if(products.isEmpty()) {
            System.out.println("\nYour Cart is Empty!\n");
            System.out.println("--------------------------\n");
            return;
        }

        System.out.println("Total Price for the Cart Product: $" + TotalPrice);
        System.out.println("--------------------------------------------");

        int result = ConfirmCartProducts.confirmCartProduct(products);

        if (result == 0) {
            return;
        }
        if(result == 2){
            return;
        }
        if(result == 3){
            System.out.println("\nEmpty the Cart is Successful\n");
            System.out.println("\nNow The Cart is Empty.\n");
            return;
        }
    }
    }
}
