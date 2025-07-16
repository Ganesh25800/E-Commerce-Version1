import ProductShopping.ProductDataLoader;
import ProductShopping.ProductShoppingCategory;
import UpdateProfile.DeleteUserProfile;
import UpdateProfile.UpdateProfileDisplay;
import ViewCart.UserCartProduct;
import ViewOrder.ViewOrderCategory;

import java.util.Scanner;

public class UserHomePage {
    public static void UserHomePageMenu(){
        System.out.println("\nWelcome "+ SessionManager.getUserFirstName() + " " + SessionManager.getUserLastName());


        while(true){
            System.out.println();
            Scanner scr = new Scanner(System.in);
            System.out.println("====================");
            System.out.println("    Home Page Menu   ");
            System.out.println("==================== ");
            System.out.println("1. Shop Products");
            System.out.println("2. View Cart");
            System.out.println("3. View My Orders");
            System.out.println("4. Update Profile");
            System.out.println("5. Logout");
            System.out.println("====================");
            System.out.print("Enter Your Choice: ");

            if(!scr.hasNextInt()){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            int choice = scr.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            String UserEmail = SessionManager.getUserEmail();
            String UserId = SessionManager.getUserId();
            String Password = SessionManager.getUserPassword();
            String FirstName = SessionManager.getUserFirstName();
            String LastName = SessionManager.getUserLastName();

            switch(choice){
                case 1:
                    ProductDataLoader PD = new ProductDataLoader();
                    ProductShoppingCategory.ProductShoppingCategoryDisplay(UserEmail);
                    break;

                case 2:
                    UserCartProduct.UserCartProductDisplay(UserEmail);
                    break;

                case 3:
                    ViewOrderCategory.ViewOrderDisplay(UserEmail);
                    break;

                case 4:
                    String result = UpdateProfileDisplay.UpdateProfileDisplayMenu(UserId,Password,FirstName,LastName,UserEmail);

                    if(result == null){
                        continue;
                    }

                    else if(result.equals("delete")){
                        boolean resultFromDatabase = DeleteUserProfile.DeleteUserProfileForever(UserEmail);
                        if(resultFromDatabase){
                            System.out.println("\nYour Account is Deleted.\n");
                            return;
                        }
                        else{
                            System.out.println("\nYour Account is not Deleted! Try Again\n");
                            continue;
                        }
                    }

                    else if (result.equals("New")) {
                        System.out.println("\nNow You Can Create New Account.\n");
                        return;
                    }

                    else if(!result.contains("@gmail.com")){
                        LoadUserDetailsAfterUpdate.UpdatingUserDetailsAfterUpdateUserId(UserEmail);
                    }

                    else{
                        LoadUserDetailsAfterUpdate.UpdatingUserDetailsAfterUpdateEMail(UserId);
                    }
                    break;

                case 5:
                    System.out.println("\nYou have successfully logged out!\n");
                    return;
            }
        }
    }
}
