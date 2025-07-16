package ViewOrder;

import java.util.Scanner;

public class ViewOrderCategory {
    public static void ViewOrderDisplay(String Email){

        while (true) {
            System.out.println("\n------------------------");
            System.out.println("         View Order     ");
            System.out.println("------------------------");
            System.out.println("1.View Order History");
            System.out.println("2.Clear Order History");
            System.out.println("3.Back");
            System.out.println("------------------------");
            Scanner scr = new Scanner(System.in);
            System.out.print("Enter your choice: ");

            if (!scr.hasNextInt()) {
                System.out.println("Please Enter Valid Number!");
                continue;
            }
            int choice = scr.nextInt();

            if (choice == 3) {
                return;
            }

            switch (choice) {
                case 1:
                    ViewPlacedOrders.ViewPlacedOrdersDisplay(Email);
                    break;

                case 2:
                    boolean result = DeleteOrderHistory.ClearOrderHistory(Email);
                    if (result) {
                        System.out.println("\nOrder History Deleted Successfully.\n");
                    }
                    else {
                        System.out.println("\nOrder History Deletion Failed! Try Again.");
                    }
                    break;
            }
        }
    }
}
