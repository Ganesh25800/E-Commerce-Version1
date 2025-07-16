package DatabaseConnection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DatabaseConnection {

    public static int counter = 0;
    public static Connection getConnection() {
        String url = "jdbc:h2:./data/ECommerceDatabase";
        String user = "sa";
        String password = "sa";

        Connection con = null;

        try {
            File dbDir = new File("./data");
            if (!dbDir.exists()) {
                dbDir.mkdirs();
            }
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            if(counter == 0) {
                CreateTables();
            }
            counter++;


        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            System.out.println(e);
        }

        return con;
    }

    public static void CreateTables(){
        String url = "jdbc:h2:./data/ECommerceDatabase";
        String user = "sa";
        String password = "sa";

        Connection con = null;

        try {
            
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS userDetails(" +
                    "firstName varchar(30)," +
                    "lastName varchar(30)," +
                    "mailId varchar(30) primary key," +
                    "userId varchar(30)," +
                    "password varchar(30))");

            stmt.execute("DROP TABLE IF EXISTS Cart");

            stmt.execute("CREATE TABLE IF NOT EXISTS Cart (" +
                    "categoryId VARCHAR(30), " +
                    "categoryName VARCHAR(100), " +
                    "subCategoryId VARCHAR(30), " +
                    "subCategoryName VARCHAR(100), " +
                    "productId VARCHAR(50), " +
                    "productBrand VARCHAR(100), " +
                    "productPrice VARCHAR(30), " +
                    "productQuantity VARCHAR(30), " +
                    "productSize VARCHAR(30), " +
                    "productAvailability VARCHAR(30), " +
                    "productGender VARCHAR(30), " +
                    "totalPrice VARCHAR(30)," +
                    "userEmail VARCHAR(30))");

            stmt.execute("CREATE TABLE IF NOT EXISTS PlacedOrder (" +
                    "orderDate DATE, " +
                    "cartId INT AUTO_INCREMENT PRIMARY KEY, " +
                    "categoryId VARCHAR(30), " +
                    "categoryName VARCHAR(100), " +
                    "subCategoryId VARCHAR(30), " +
                    "subCategoryName VARCHAR(100), " +
                    "productId VARCHAR(50), " +
                    "productBrand VARCHAR(100), " +
                    "productPrice VARCHAR(30), " +
                    "productQuantity VARCHAR(30), " +
                    "productSize VARCHAR(30), " +
                    "productAvailability VARCHAR(30), " +
                    "productGender VARCHAR(30), " +
                    "totalPrice VARCHAR(30), " +
                    "userId VARCHAR(30))"
            );


        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
