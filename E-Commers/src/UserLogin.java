import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {

    public static void UserLoginMenu(){
        Scanner input = new Scanner(System.in);
        String UserID = "";
        String Password = "";

        int count = 0;

        while(true){

            if(count == 0){
                System.out.print("\nEnter your UserID: ");
                UserID = input.nextLine().toLowerCase();
                count++;
            }
            if(UserID.equals("")){
                System.out.println("\nPlease enter your UserID!\n");
                count--;
                continue;
            }
            if(count == 1){
                System.out.print("Enter your Password: ");
                Password = input.nextLine().toLowerCase();
                count++;
            }
            if(Password.equals("")){
                System.out.println("\nPlease enter your Password!\n");
                count--;
                continue;
            }

            boolean result = CheckingUserDetailsInDatabase(UserID,Password);

            if(result){
                //change here
                UserHomePage.UserHomePageMenu();
            }

            return;
        }
    }

    public static boolean CheckingUserDetailsInDatabase(String UserId, String Password) {
        Connection conn = H2DatabaseConnection.getConnection();
        User user;
        boolean result = false;

        try{
            String query = "SELECT * FROM userDetails Where (userId = ? OR mailId = ?) AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, UserId);
            ps.setString(2, UserId);
            ps.setString(3, Password);

            ResultSet rs = ps.executeQuery();

            result = rs.next();

            user = new User();

            if(result){
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("mailId"));
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
            }

            SessionManager.setCurrectUser(user);
        } catch(Exception e){
            System.out.println(e);
        }

        if(!result){
            System.out.println("\nInvalid UserID/Password! Try again!");
            System.out.println("If You are a new user, please SignUp!\n");
        }
        return result;
    }
}
