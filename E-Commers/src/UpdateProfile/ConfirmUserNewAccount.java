package UpdateProfile;

import java.util.Scanner;

public class ConfirmUserNewAccount {
    public static String UserNewAccountConfirmation(){
        String Action = "New";

        System.out.println("\nTo Create New Account, You Will be Directed To Login Page.");
        System.out.println("You can SignUp and Create a New Account");
        System.out.println("To Undo or Go Back Press 'b'.");
        Scanner scr = new Scanner(System.in);
        System.out.print("Press any key to continue...");
        String input = scr.nextLine();

        if(input.equalsIgnoreCase("b")){
            return null;
        }

        return Action;
    }
}
