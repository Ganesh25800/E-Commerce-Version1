import java.util.Scanner;

public class ProjectFlowDisplay {
    public static void ProjectFlowDisplayMenu() {
        Scanner scr = new Scanner(System.in);
        System.out.println("\n---> Developer Note: ");
        System.out.println();
        System.out.println("By Selecting This Option,\nYou'll learn how this project was built and the approaches used in each module.");
        System.out.println("In this option You only explore and understand the project by explanation.");
        System.out.print("Press any Key to Continue... ");
        String response = scr.nextLine();

        while(true) {
            Scanner scr1 = new Scanner(System.in);
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println(" Choose Option You Want To Explore ");
            System.out.println("-----------------------------------");
            System.out.println("1.About Database");
            System.out.println("2.Accessing the data & Database Approach");
            System.out.println("3.Project File Structuring");
            System.out.println("4.Product Shopping Approach");
            System.out.println("5.How Add To Cart & Order History Approach");
            System.out.println("6.Updating Profile Approach");
            System.out.println("7.Over View Of Complete Project");
            System.out.println("8.-> Developer Details <-");
            System.out.println("9. <- Back To Main Menu");
            System.out.println("-----------------------------------");
            System.out.print("Enter Your Choice: ");

            int choice = 0;

            try{
                choice = Integer.parseInt(scr.nextLine());
            } catch (Exception e){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            if(choice == 9) {
                System.out.println("\nReturning to Main Menu...");
                return;
            }

            switch(choice) {
                case 1:
                    System.out.println("\n--> About Database:");
                    System.out.println();
                    System.out.println("This project uses the H2 embedded SQL database.");
                    System.out.println("H2 is a lightweight, fast Java-based database that runs inside the application.");
                    System.out.println("All data such as user details, cart items, and placed orders are stored in H2.");
                    System.out.println("When the application runs for the first time, it automatically creates the database file.");
                    System.out.println("The database is located at: ./data/ECommerceDatabase.mv.db");
                    System.out.println("It contains 3 main tables:");
                    System.out.println("  - userDetails: stores registered users' data.");
                    System.out.println("  - Cart: temporarily stores products added by users.");
                    System.out.println("  - PlacedOrder: stores order history after placing orders.");
                    System.out.println("The database file is auto-generated and ignored from GitHub using .gitignore.");
                    System.out.println("This allows every user to start fresh when running the app.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 2:
                    System.out.println("\n--> Accessing the Data & Database Approach:");
                    System.out.println();
                    System.out.println("The application uses JDBC (Java Database Connectivity) to interact with the H2 database.");
                    System.out.println("JDBC allows executing SQL queries directly from Java code.");
                    System.out.println("The connection is managed by the class: H2DatabaseConnection.java");
                    System.out.println("Key points of the database approach:");
                    System.out.println("  - A single connection is reused to avoid opening new connections every time.");
                    System.out.println("  - SQL queries are written directly using PreparedStatement to prevent SQL injection.");
                    System.out.println("  - The getConnection() method checks if it's the first time running and creates tables automatically.");
                    System.out.println("  - Data like user registration, login validation, cart actions, and order storage are all done through SQL.");
                    System.out.println("  - Tables are created only once using IF NOT EXISTS, so rerunning the app won't affect existing data.");
                    System.out.println("This approach is simple, lightweight, and perfect for a console-based standalone project.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 3:
                    System.out.println("\n--> Project File Structuring:");
                    System.out.println();
                    System.out.println("The project follows a clean modular structure using Java packages.");
                    System.out.println("Each major functionality is placed in its own package for better separation and maintenance.");
                    System.out.println("Here’s how the project is organized:");
                    System.out.println();
                    System.out.println(" 1. Main Files:");
                    System.out.println("    - ECommerceHome.java: The main entry point of the application.");
                    System.out.println("    - SessionManager.java: Maintains current logged-in user info.");
                    System.out.println();
                    System.out.println(" 2. DatabaseConnection Package:");
                    System.out.println("    - H2DatabaseConnection.java: Handles DB connection and table creation.");
                    System.out.println();
                    System.out.println(" 3. ProductShopping Package:");
                    System.out.println("    - Handles loading product categories and subcategories from CSV files.");
                    System.out.println("    - Lets users browse and select products.");
                    System.out.println();
                    System.out.println(" 4. ViewCart Package:");
                    System.out.println("    - Manages the user's cart.");
                    System.out.println("    - Supports confirming cart items and placing orders.");
                    System.out.println();
                    System.out.println(" 5. ViewOrder Package:");
                    System.out.println("    - Displays order history.");
                    System.out.println("    - Allows deleting order records.");
                    System.out.println();
                    System.out.println(" 6. UpdateProfile Package:");
                    System.out.println("    - Lets users update email, name, password, and user ID.");
                    System.out.println("    - Also includes account deletion.");
                    System.out.println();
                    System.out.println(" 7. ProjectFlow Package:");
                    System.out.println("    - Displays how the project is built (this menu).");
                    System.out.println();
                    System.out.println("This structured approach improves readability, debugging, and long-term scalability.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 4:
                    System.out.println("\n--> Product Shopping Approach:");
                    System.out.println();
                    System.out.println("The product shopping feature is designed to simulate real-world browsing through categories and products.");
                    System.out.println("Here’s how it works:");
                    System.out.println();
                    System.out.println(" 1. Data Source:");
                    System.out.println("    - Product data is stored in external CSV files (products.csv, categories.csv, subproducts.csv).");
                    System.out.println("    - These files are loaded at runtime using BufferedReader.");
                    System.out.println();
                    System.out.println(" 2. ProductShopping Package:");
                    System.out.println("    - Contains classes like ProductShoppingCategory, ProductShoppingSubProductPage,");
                    System.out.println("      and ProductShoppingProduct to handle user navigation.");
                    System.out.println("    - Displays categories first, then subcategories, then products.");
                    System.out.println();
                    System.out.println(" 3. Selection Flow:");
                    System.out.println("    - User selects a category → sees subcategories → selects a subcategory → views related products.");
                    System.out.println("    - Each product displayed includes name, size, price, availability, and gender.");
                    System.out.println();
                    System.out.println(" 4. Confirmation:");
                    System.out.println("    - Before adding to cart, the product is confirmed through ProductConfirmation.java.");
                    System.out.println();
                    System.out.println("This modular flow ensures a clean, step-by-step experience similar to real e-commerce platforms.");
                    System.out.println("It also separates data loading from user interaction logic for better maintainability.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 5:
                    System.out.println("\n--> Add to Cart & Order History Approach:");
                    System.out.println();
                    System.out.println("This section handles the full purchase flow — from adding items to the cart to viewing past orders.");
                    System.out.println();
                    System.out.println(" 1. Adding to Cart:");
                    System.out.println("    - When a user selects a product, it is confirmed using ProductConfirmation.java.");
                    System.out.println("    - If confirmed, the product is added to the Cart table in the database.");
                    System.out.println("    - Each cart item includes: category, subcategory, product ID, brand, price, size, quantity, etc.");
                    System.out.println("    - The userEmail field links the cart item to the current logged-in user.");
                    System.out.println();
                    System.out.println(" 2. Viewing the Cart:");
                    System.out.println("    - The ViewCart package includes classes to fetch and display cart items.");
                    System.out.println("    - Users can confirm the items they wish to order.");
                    System.out.println();
                    System.out.println(" 3. Placing the Order:");
                    System.out.println("    - Confirmed cart items are moved from the Cart table to the PlacedOrder table.");
                    System.out.println("    - The orderDate is stored along with all product details.");
                    System.out.println("    - After a successful order, the cart is automatically cleared.");
                    System.out.println();
                    System.out.println(" 4. Order History:");
                    System.out.println("    - The ViewOrder package allows users to see previously placed orders.");
                    System.out.println("    - Orders are grouped by user ID and sorted by order date.");
                    System.out.println("    - Users can also delete their order history if needed.");
                    System.out.println();
                    System.out.println("This flow closely models real e-commerce systems, while being simple and console-friendly.");
                    System.out.println("It shows clear use of database operations, modular code design, and user session tracking.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 6:
                    System.out.println("\n--> Updating Profile Approach:");
                    System.out.println();
                    System.out.println("The profile update system allows users to manage and modify their personal account details.");
                    System.out.println("This functionality is handled within the UpdateProfile package.");
                    System.out.println();
                    System.out.println(" 1. What Can Be Updated:");
                    System.out.println("    - First Name");
                    System.out.println("    - Last Name");
                    System.out.println("    - Email ID");
                    System.out.println("    - User ID");
                    System.out.println("    - Password");
                    System.out.println();
                    System.out.println(" 2. Modular Update Classes:");
                    System.out.println("    - Each field has a dedicated class (e.g., UpdateUserEmail.java, UpdateUserPassword.java).");
                    System.out.println("    - This makes the code organized and easier to manage.");
                    System.out.println();
                    System.out.println(" 3. Database Handling:");
                    System.out.println("    - Updates are executed using SQL UPDATE statements via JDBC.");
                    System.out.println("    - The mailId (primary key) is used to locate the correct user record.");
                    System.out.println();
                    System.out.println(" 4. User Confirmation & Security:");
                    System.out.println("    - Users are asked to confirm their current credentials before making changes.");
                    System.out.println("    - This prevents unauthorized changes.");
                    System.out.println();
                    System.out.println(" 5. Session Update:");
                    System.out.println("    - After changes, SessionManager is updated to reflect the latest user data.");
                    System.out.println();
                    System.out.println("This approach keeps profile management secure, flexible, and easy to extend.");
                    System.out.println("It also demonstrates good use of modularity and session-based updates in a console application.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 7:
                    System.out.println("\n--> Overview of the Complete Project:");
                    System.out.println();
                    System.out.println("This project is a complete console-based E-Commerce application built in Java.");
                    System.out.println("It simulates a real shopping experience — from registration to browsing, cart management,");
                    System.out.println("order placement, and account/profile handling.");
                    System.out.println();
                    System.out.println(" 1. Core Technologies Used:");
                    System.out.println("    - Java (Core + OOP Concepts)");
                    System.out.println("    - JDBC (Java Database Connectivity)");
                    System.out.println("    - H2 Embedded SQL Database");
                    System.out.println("    - CSV File Handling (BufferedReader)");
                    System.out.println();
                    System.out.println(" 2. Key Features:");
                    System.out.println("    - User Sign Up and Login with Session Tracking");
                    System.out.println("    - Product Browsing using Category and Subcategory logic");
                    System.out.println("    - Add to Cart, View Cart, Place Orders, and View Order History");
                    System.out.println("    - Profile Update and Account Deletion");
                    System.out.println("    - Developer Notes and Project Explanation for learning/demo purposes");
                    System.out.println();
                    System.out.println(" 3. Clean Architecture:");
                    System.out.println("    - Code is divided into logical packages (ProductShopping, ViewCart, UpdateProfile, etc.)");
                    System.out.println("    - Each responsibility is separated into its own class for better maintainability");
                    System.out.println();
                    System.out.println(" 4. Real-World Relevance:");
                    System.out.println("    - This project showcases full-stack backend logic using Java and SQL.");
                    System.out.println("    - It models real shopping flow and database interaction patterns.");
                    System.out.println("    - Suitable for demonstrating your skills in interviews, resumes, and GitHub portfolio.");
                    System.out.println();
                    System.out.println("This project proves your ability to take an idea from concept to fully functional implementation.");
                    System.out.println("It highlights logical thinking, structured coding, and backend application design.\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;

                case 8:
                    System.out.println("\n Developer Details ------");
                    System.out.println("--> Name: Chinthalacheruvu Ganesh Reddy");
                    System.out.println("--> Email: ganeshreddy25800@gmail.com");
                    System.out.println("--> Education: Master's in Computer Science");
                    System.out.println("--> Portfolio: www.chinthalacheruvuganeshreddy.com");
                    System.out.println("--> LinkedIn: https://www.linkedin.com/in/ganesh-reddy-chinthalacheruvu-316945284/\n");
                    System.out.print("press any Key to Continue... ");
                    scr1.nextLine();
                    break;
            }
        }

    }
}
