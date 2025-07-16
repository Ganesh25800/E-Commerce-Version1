package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUserId {
    public static String UpdateUserID(String oldUserId){
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter New User ID: ");

        String newUserID = scr.nextLine();

        boolean result = UpdateUserIdInDatabase(newUserID,oldUserId);

        if(result){
            System.out.println("\nNew User ID Updated\n");
            return newUserID;
        }
        else{
            System.out.println("\nNew User ID Not Updated\n");
            return null;
        }
    }

    public static boolean UpdateUserIdInDatabase(String newUserID, String oldUserID){

        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "UPDATE userDetails SET userId = ? WHERE userId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,newUserID);
            ps.setString(2,oldUserID);

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
