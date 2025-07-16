package ViewOrder;

import java.util.ArrayList;
import java.util.List;

public class ViewPlacedOrders {
    public static void ViewPlacedOrdersDisplay(String UserEmail){

        List<List<String>> UserOrders = GetUserOrdersFromDatabase.returnUserOrders(UserEmail);

        if(UserOrders.isEmpty()){
            System.out.println("\nNo Orders Found\n");
            return;
        }

        System.out.println("---------------------------------");
        System.out.println("           Your Orders           ");
        System.out.println("---------------------------------");

        int counter = 0;
        for(List<String> order : UserOrders){
            counter++;

            System.out.println("Item "+counter+":");
            System.out.println("Ordered Date: "+order.get(0));
            System.out.println("Category: "+order.get(2));
            System.out.println("SubCategory: "+order.get(4));
            System.out.println("Brand: "+order.get(6));
            System.out.println("Price: $"+order.get(7));
            double price = 0;
            try {
                 price = Double.parseDouble(order.get(7));
            }catch(Exception e){
                System.out.println("Invalid Price");
            }
            System.out.println("Quantity: "+order.get(8)+"x");
            int quantity = 0;
            try {
                 quantity = Integer.parseInt(order.get(8));
            }catch(Exception e){
                System.out.println("Invalid Quantity");
            }
            System.out.println("Size: "+order.get(9));
            System.out.println("Gender: "+order.get(11));
            System.out.println("Total Price: $"+price*quantity);

            System.out.println();
        }
        
        System.out.println("---------------------------------");
    }
}
