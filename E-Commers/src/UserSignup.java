import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserSignup {
    public static void UserSignUpMenu(){
        Scanner scr = new Scanner(System.in);

        String firstName = "";
        String lastName = "";
        String email = "";
        String userId = "";
        String password = "";

        System.out.println("\nPlease Enter Below Details to create Account\n");
        System.out.println("----------------------------------------------");

        int count = 0;
        while(true){

            if(count == 0){
                System.out.print("Enter Your First Name: ");
                firstName = scr.nextLine().toLowerCase();
                count++;
            }
            if(firstName.equals("")){
                System.out.println("\nPlease Enter Your First Name!\n");
                count--;
                continue;
            }

            if(count == 1){
                System.out.print("Enter Your Last Name: ");
                lastName = scr.nextLine().toLowerCase();
                count++;
            }
            if(lastName.equals("")){
                System.out.println("\nPlease Enter Your Last Name!\n");
                count--;
                continue;
            }

            if(count == 2){
                System.out.print("Enter Your Gmail: ");
                email = scr.nextLine().toLowerCase();
                count++;
            }
            if(email.equals("")){
                System.out.println("\nPlease Enter Your Gmail!\n");
                count--;
                continue;
            }
            if(!email.contains("@gmail.com")){
                System.out.println("\nPlease Enter Valid Gmail!\n");
                count--;
                continue;
            }

            if(count == 3){
                System.out.print("Enter Your User ID: ");
                userId = scr.nextLine().toLowerCase();
                count++;
            }
            if(userId.equals("")){
                System.out.println("\nPlease Enter Your User ID!\n");
                count--;
                continue;
            }

            if(count == 4){
                System.out.print("Enter Your Password: ");
                password = scr.nextLine().toLowerCase();
                count++;
            }
            if(password.equals("")){
                System.out.println("\nPlease Enter Your Password!\n");
                count--;
                continue;
            }
            if(password.contains(" ")){
                System.out.println("\nPassword Must Not Contain Spaces!\n");
                count--;
                continue;
            }
            if(password.length() < 6){
                System.out.println("\nPassword must be at least 6 characters!\n");
                count--;
                continue;
            }

            String confirmPassword = "";

            if(count == 5){
                System.out.print("Confirm Password: ");
                confirmPassword = scr.nextLine().toLowerCase();
                count++;
            }

            if(!password.equals(confirmPassword)){
                System.out.println("\nPasswords do not match!\n");
                count--;
                count--;
                continue;
            }

            boolean result = StoringUserDetailsInDatabase(firstName, lastName, email, userId, password);

            if(result) {
                System.out.println("\nYou have successfully created your account.\n");

            }
            else{
                System.out.println("\nSomething went wrong! Please Try Again\n");
            }
            return;
        }
    }

    public static boolean StoringUserDetailsInDatabase(String firstName, String LastName,
                                                       String email, String userId, String password){

        boolean result = false;

        try {
            Connection con = H2DatabaseConnection.getConnection();

            //Before Inserting the Details into Database, Check the details exist or not.

            boolean StatusOfUserDetails = CheckingUserDetailsInDatabase(con,email,userId);

            if(StatusOfUserDetails){
                System.out.println("\nDetails You Provided Already Exist! Use Different GMail or UserId!\n");
                return false;
            }

            String query = "INSERT INTO userDetails(firstName, lastName, mailId, userId, password) VALUES(?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, firstName);
            st.setString(2, LastName);
            st.setString(3, email);
            st.setString(4, userId);
            st.setString(5, password);

            int rows = st.executeUpdate();

            result = rows > 0;

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(LastName);
            user.setEmail(email);
            user.setUserId(userId);
            user.setPassword(password);

            SessionManager.setCurrectUser(user);

            con.close();
        } catch(Exception e){
            System.out.println(e);
            return false;
        }

        return result;
    }

    public static boolean CheckingUserDetailsInDatabase(Connection con, String email, String userId){
        boolean result = false;

        try{
            String query = "SELECT Count(*) FROM userDetails WHERE mailId = ? OR userId = ?";

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, userId);

            ResultSet rs = st.executeQuery();

            if(rs.next()){
                result = rs.getInt(1) > 0;
            }


        } catch(Exception e){
            System.out.println(e);
            return false;
        }

        return result;
    }
}
