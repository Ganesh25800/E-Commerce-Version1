package ProductShopping;

import ProductShopping.FileClasses.ProductClass;

import java.util.Scanner;

public class ProductConfirmation {

    public static int ProductConfirmationBeforeAddingToCart(String CategoryID, String CategoryName,
                                                             String SubProductID, String SubProductName,
                                                            ProductClass UserSelectedProduct) {
       int Quantity = 1;
       double TotalPrice = 0;

        while(true) {
            Scanner scr = new Scanner(System.in);
            System.out.print("Enter the Quantity of Product: ");

            if (!scr.hasNextInt()) {
                System.out.println("\nPlease Enter the Number of Quantity!\n");
                continue;
            }

            if (scr.hasNextInt()) {
                Quantity = scr.nextInt();
                break;
            }
        }

        while(true){
            Scanner scr = new Scanner(System.in);

            System.out.println("\n----------------------------------");
            System.out.println("        Confirm Your Product       ");
            System.out.println("-----------------------------------");
            System.out.println("Category: " + CategoryName);
            System.out.println("Sub-Product: " + SubProductName);
            System.out.println("Brand: " + UserSelectedProduct.getProductName());
            System.out.println("Size: " + UserSelectedProduct.getProductSize());
            System.out.println("Availability: " + UserSelectedProduct.getProductAvailability());
            System.out.println("Gender: " + UserSelectedProduct.getGender());

            String strPrice = UserSelectedProduct.getProductPrice().trim();

            double Price = 0;

            if(strPrice == null || strPrice.isEmpty()) {
                System.out.println("\nPrice Error!\n");
            } else {
                Price = Double.parseDouble(strPrice.trim());
            }

            System.out.println("Price: $" + Price);
            System.out.println("Quantity: " + Quantity+"x");

            TotalPrice = Quantity * Price;
            System.out.println("----------------------------------");
            System.out.println("Total Price: $" + TotalPrice);
            System.out.println("----------------------------------");
            System.out.println("Press 'c' to cancel the product & go back.");
            System.out.println("Press 'a' to Add to Cart.");
            System.out.print("Enter your choice: ");

            if (!scr.hasNext()){
                System.out.println("\nPlease Enter Correct Option!\n");
                continue;
            }

            char ch;

            try {
                ch = scr.next().toLowerCase().charAt(0);
            } catch (Exception e) {
                System.out.println("\nPlease Enter Valid Option!\n");
                continue;
            }

            if(ch == 'c'){
                return 0;
            }

            if(ch == 'a'){
               boolean result = AddToCart.AddProductToCart(CategoryID, CategoryName, SubProductID, SubProductName,
                                                            UserSelectedProduct,Quantity,TotalPrice);

               if(result){
                   System.out.println("\nProduct Added To Cart Successfully!");
                   return 0;
               }
               else{
                   System.out.println("\nProduct Not Added Successfully!");
               }

            }
        }
    }
}
