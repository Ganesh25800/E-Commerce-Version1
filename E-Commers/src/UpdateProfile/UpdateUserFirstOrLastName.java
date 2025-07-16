package UpdateProfile;

import DatabaseConnection.H2DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUserFirstOrLastName {
    public static String UpdateUserChoice(String Email){
        String Name = "UpdateUserChoice";

        while(true){
            Scanner scr = new Scanner(System.in);
            System.out.println("\n----------------------");
            System.out.println("      Update Choice    ");
            System.out.println("-----------------------");
            System.out.println("1.First Name");
            System.out.println("2.Last Name");
            System.out.println("3.Back");
            System.out.println("-----------------------");
            System.out.print("Enter your choice: ");

            if(!scr.hasNextInt()){
                System.out.println("\nPlease Enter Valid Choice!\n");
                continue;
            }

            int choice = scr.nextInt();
            if(choice < 1 || choice > 3){
                System.out.println("\nPlease Enter Valid Choice!\n");
                continue;
            }
            if(choice == 3){
                break;
            }
            if(choice == 1){
                boolean resultFirstName = UpdateUserFirstName(Email);
                break;
            }
            if(choice == 2){
                boolean resultLastName = UpdateUserLastName(Email);
                break;
            }
        }
        return Name;
    }

    public static boolean UpdateUserFirstName(String Email){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine().trim();

        if(firstName.isEmpty()){
            System.out.println("\nPlease Enter Valid First Name!\n");
            return false;
        }

        boolean FirstName = UpdateUserFirstNameInDatabase(firstName,Email);

        if(FirstName){
            System.out.println("\nFirst Name Updated Successfully!\n");
            return true;
        }
        System.out.println("\nFirst Name Update Failed! Try Again!\n");
        return false;
    }

    public static boolean UpdateUserFirstNameInDatabase(String firstName, String email){
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "UPDATE userDetails SET firstName = ? WHERE mailId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,firstName);
            ps.setString(2,email);

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

    public static boolean UpdateUserLastName(String Email){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Last Name: ");
        String firstName = sc.nextLine().trim();

        if(firstName.isEmpty()){
            System.out.println("\nPlease Enter Valid Last Name!\n");
            return false;
        }

        boolean LastName = UpdateUserLastNameInDatabase(firstName,Email);

        if(LastName){
            System.out.println("\nLast Name Updated Successfully!\n");
            return true;
        }
        System.out.println("\nLast Name Update Failed! Try Again!\n");
        return false;
    }

    public static boolean UpdateUserLastNameInDatabase(String LastName, String email){
        Connection conn = H2DatabaseConnection.getConnection();
        String sql = "UPDATE userDetails SET lastName = ? WHERE mailId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,LastName);
            ps.setString(2,email);

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
