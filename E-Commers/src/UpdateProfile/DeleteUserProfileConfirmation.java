package UpdateProfile;

import java.util.Scanner;

public class DeleteUserProfileConfirmation {

    public static String deleteUserProfileConfirmation(String Email, String UserId) {
        String Action = "delete";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Email address or UserId: ");
        String Id = sc.nextLine().toLowerCase();

        if (!Id.equalsIgnoreCase(Email) && !Id.equalsIgnoreCase(UserId)) {
            System.out.println("\nEmail or UserId Didn't Match\n");
            return null;
        }

        Scanner scr1 = new Scanner(System.in);
        System.out.println("\nYou Can Delete Your Account, Please Confirm!");
        System.out.println("You Will Be Logged Out Once Account Deletion Complete.");
        System.out.println("To Undo this Action press 'b'.");
        System.out.print("Press any key to continue...");
        String answer = scr1.nextLine();

        if (answer.equals("b")) {
            return null;
        }

        while (true) {
            Scanner scr = new Scanner(System.in);

            System.out.println("--------------------------");
            System.out.println(" Confirm Account Deletion ");
            System.out.println("--------------------------");
            System.out.println("1.Delete Account");
            System.out.println("2.Back");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");

            if(!scr.hasNextInt()){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            int choice = scr.nextInt();

            if (choice == 1) {
                break;
            }
            if (choice == 2) {
                return null;
            }
        }
        return Action;
    }
}
