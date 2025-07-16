package ViewCart;

import java.util.List;
import java.util.Scanner;

public class ConfirmCartProducts {

    public static int confirmCartProduct(List<List<String>> UserConfirmedProducts) {
        while(true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("1.Confirm your product & Place Order.");
            System.out.println("2.Empty Cart");
            System.out.println("0.Cancel & Go Back!");
            System.out.print("Enter your choice: ");

            if (!scr.hasNextInt()) {
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }
            int choice = scr.nextInt();

            if(choice == 0) {
                return 0;
            }
            if(choice == 2){
                boolean result = EmptyCartAfterPlacingOrder.EmptyCart();
                if(result) {
                    return 3;
                }
                else{
                    continue;
                }
            }
            if(choice == 1) {
                boolean result = PlaceTheOrder.PlaceTheConfirmedOrder(UserConfirmedProducts);

                if(!result) {
                    System.out.println("\nOrder Not Placed!\n");
                    return 2;
                }
                else {
                    return 2;
                }
            }
            return 1;
        }
    }

}
