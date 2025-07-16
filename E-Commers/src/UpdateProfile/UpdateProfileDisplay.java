package UpdateProfile;

import java.util.Scanner;

public class UpdateProfileDisplay {
    public static String UpdateProfileDisplayMenu(String UserId, String Password,
                                                String FirstName, String LastName, String Email) {

        while(true){
            System.out.println("\n-------------------------");
            System.out.println("      Update Profile     ");
            System.out.println("-------------------------");

            System.out.println("1. Display profile");
            System.out.println("2. Update User ID");
            System.out.println("3. Update Password");
            System.out.println("4. Show Password");
            System.out.println("5. Update Email");
            System.out.println("6. Update First & Last Name");
            System.out.println("7. Delete Account");
            System.out.println("8. Create New Account");
            System.out.println("9. Back");

            System.out.println("-------------------------");
            Scanner scr = new Scanner(System.in);
            System.out.print("Enter your choice: ");

            if(!scr.hasNextInt()){
                System.out.println("\nPlease enter a valid number!\n");
                continue;
            }
            int choice = scr.nextInt();

            if(choice < 1 || choice > 9){
                System.out.println("\nPlease enter a valid number!\n");
                continue;
            }

            if(choice == 9){
                return null;
            }

            switch(choice){
                case 1:
                    DisplayProfile.DisplayUserProfile(UserId,Password,FirstName,LastName,Email);
                    return null;

                case 2:
                    String userId = UpdateUserId.UpdateUserID(UserId);
                    return userId;

                case 3:
                    String newPassword = UpdateUserPassword.UserUpdatedPassword(Password, Email);
                    return newPassword;

                case 4:
                    DisplayProfile.DisplayPassword(Password);
                    return null;

                case 5:
                    String EmailID = UpdateUserEmail.updateUserEmail(UserId, Email);
                    return EmailID;

                case 6:
                    String UserNameUpdate = UpdateUserFirstOrLastName.UpdateUserChoice(Email);
                    return UserNameUpdate;

                case 7:

                    String UserChoice = DeleteUserProfileConfirmation.deleteUserProfileConfirmation(Email, UserId);
                    return UserChoice;

                case 8:
                    String UserNewAccount = ConfirmUserNewAccount.UserNewAccountConfirmation();
                    return UserNewAccount;

            }

        }

    }
}
