import ProductShopping.ProductDataLoader;

import java.util.Scanner;

public class ECommerceHome {
    public static void main(String[] args) {

        System.out.println("\nWelcome to the E-Commerce Application");

        while(true){
            Scanner input = new Scanner(System.in);

            System.out.println("===================");
            System.out.println("     Login Menu    ");
            System.out.println("===================");
            System.out.println("1.Login");
            System.out.println("2.Signup");
            System.out.println("3.How This Project Was Built");
            System.out.println("4.Exit");
            System.out.println("===================");
            System.out.print("Enter your choice: ");

            if(!input.hasNextInt()){
                System.out.println("\nPlease Enter Whole Number! \n");
                continue;
            }

            int choice = input.nextInt();

            if(choice < 1 || choice > 4){
                System.out.println("\nPlease Enter Valid Number!\n");
                continue;
            }

            switch(choice){
                case 1:
                    ProductDataLoader loader = new ProductDataLoader();
                    UserLogin.UserLoginMenu();
                    break;

                case 2:
                    UserSignup.UserSignUpMenu();
                    break;

                case 3:
                    ProjectFlowDisplay.ProjectFlowDisplayMenu();
                    break;

                case 4:
                    System.exit(0);
                    break;

            }
        }
    }
}
