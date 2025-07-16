package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUserEmail {
    public static String updateUserEmail(String userId,String email) {
        while(true){
            Scanner scr = new Scanner(System.in);
            System.out.print("Enter New Email address: ");
            String newEmail = scr.nextLine().toLowerCase();

            if(newEmail.equals(email)){
                System.out.println("\nPlease Enter New Email!\n");
                continue;
            }

            if(!newEmail.contains("@gmail.com") || newEmail.contains(" ")){
                System.out.println("\nPlease Enter Valid Email!\n");
                continue;
            }

            boolean CheckUserNewEmailInDatabaseForExistence =
                    CheckingNewUserEmailInDatabase.CheckUserNewEmailInDatabase(newEmail);

            if(!CheckUserNewEmailInDatabaseForExistence){
                System.out.println("\nNew Email You Entered, Already Exist, Enter New Mail Id!\n");
                continue;
            }

            boolean result = UpdateNewEmailInDatabase(newEmail,userId);

            if(result){
                System.out.println("\nEmail Updated Successfully!\n");
                return newEmail;
            }
            else{
                System.out.println("\nNew Email Didn't Updated! Try Again\n");
                break;
            }
        }
        return null;
    }

    public static boolean UpdateNewEmailInDatabase(String newEmail,String userID) {
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "UPDATE userDetails SET mailId = ? WHERE userId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,newEmail);
            ps.setString(2,userID);

            int rows = ps.executeUpdate();

            if(rows > 0){
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
}
