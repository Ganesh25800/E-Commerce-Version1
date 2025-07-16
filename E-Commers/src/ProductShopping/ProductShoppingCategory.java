package ProductShopping;

import java.util.*;

public class ProductShoppingCategory {
    public static String UserMail = "";
    public static void ProductShoppingCategoryDisplay(String UserEmail) {
        UserMail = UserEmail;
        System.out.println("\nHere are some Categories");
        System.out.println("Which Category you want to explore.\n");

        Map<String,String> TempCategory;
        ProductDataLoader PDL = new ProductDataLoader();
        TempCategory = PDL.getCategory();

        while(true) {
            System.out.println("--------------------------------");
            System.out.println("         Category Menu          ");
            System.out.println("--------------------------------");
            int NextLineCounter = 0;

            for(String a :TempCategory.keySet()) {
                NextLineCounter++;
                System.out.println(NextLineCounter+"."+TempCategory.get(a));
            }

            System.out.println("--------------------------------");

            Scanner scr = new Scanner(System.in);
            System.out.println("If You want to Go Back To Main Menu! Press 'b' !");
            System.out.print("Enter Your Choice: ");

            if(!scr.hasNext()) {
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            String UserChoice = scr.nextLine().toLowerCase();

            if(UserChoice.equals("b")) {
                return;
            }

            int choice = 0;

            try{
                choice = Integer.parseInt(UserChoice);
            } catch(Exception e){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            if(choice < 1 || choice > TempCategory.size()) {
                System.out.println("\nPlease Select a Valid Number! between 1 to "+TempCategory.size()+"!\n");
                continue;
            }


            String UserSelectedCategoryId = "";
            String UserSelectedCategoryName = "";

            int TempChoice = 0;

            for(String a :TempCategory.keySet()) {
                TempChoice++;
                if(choice == TempChoice) {
                    UserSelectedCategoryId = a;
                    UserSelectedCategoryName = TempCategory.get(a);
                }
            }

            int result = ProductShopingSubProductPage.ProductShopingSubProductPageDisplay(UserSelectedCategoryId,UserSelectedCategoryName);

            if(result == 0){
                return;
            }
        }
    }
}
