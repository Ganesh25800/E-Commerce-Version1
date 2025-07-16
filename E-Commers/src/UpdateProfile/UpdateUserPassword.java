package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUserPassword {
    public static String UserUpdatedPassword(String oldPassword, String Email){
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter Your Current Password: ");

        String newPassword = scr.nextLine();
        String newPasswordInDatabaseFormated = newPassword.toLowerCase();

        if (!oldPassword.equals(newPasswordInDatabaseFormated)) {
            System.out.println("\nCurrent Password Didn't Match!\n");
            return null;
        }

        Scanner scr1 = new Scanner(System.in);
        System.out.print("Enter Your New Password: ");
        String newPassword1 = scr1.nextLine();

        Scanner scr2 = new Scanner(System.in);
        System.out.print("Confirm Your New Password: ");
        String newPassword2 = scr2.nextLine();

        if (newPassword1.equals(newPassword2)) {
            boolean result = UpdatePasswordInDatabase(newPassword1.toLowerCase(), Email);
            if (result) {
                System.out.println("\nNew Password Updated Successfully!\n");
                return "password";
            }
            else {
                System.out.println("\nNew Password didnt updated in Database!\n");
            }
        }
        else{
            System.out.println("\nNew Password Didn't Match! Try Again\n");
            return null;
        }
        return null;
    }

    public static boolean UpdatePasswordInDatabase(String newPassword, String Email){
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "UPDATE userDetails SET password = ? WHERE mailId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,newPassword);
            ps.setString(2,Email);

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
