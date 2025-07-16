package UpdateProfile;

import java.util.Scanner;

public class DisplayProfile {
    public static void DisplayUserProfile(String UserId, String Password,
                                          String FirstName, String LastName, String Email) {

            System.out.println("-----------------------------");
            System.out.println("         User Profile        ");
            System.out.println("-----------------------------");
            System.out.println("First Name: " + FirstName);
            System.out.println("Last Name: " + LastName);
            System.out.println("Email: " + Email);
            System.out.println("UserID: " + UserId);
            int PasswordLength = Password.length();
            System.out.print("Password: ");
            for (int i = 0; i < PasswordLength; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("-----------------------------");

            Scanner scr = new Scanner(System.in);
            System.out.print("Press any key to continue...");
            String input = scr.nextLine();

    }

    public static void DisplayPassword(String Password) {

        Scanner scr = new Scanner(System.in);
        System.out.print("Enter Your Current Password: ");

        String password = scr.nextLine();
        String passwordInDatabase = password.toLowerCase();

        if (passwordInDatabase.equals(Password)) {
            System.out.println("\nYour Current Password Is: " + password + "\n");

        } else {
            System.out.println("\nYour Password Does Not Match! Try Again!\n");
            return;
        }
        Scanner scr2 = new Scanner(System.in);
        System.out.print("Press any key to continue...");
        String input2 = scr2.nextLine();
    }
}
