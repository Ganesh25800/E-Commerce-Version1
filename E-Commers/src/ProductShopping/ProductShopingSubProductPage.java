package ProductShopping;

import ProductShopping.FileClasses.SubProductClass;

import java.util.*;

public class ProductShopingSubProductPage {
    public static int ProductShopingSubProductPageDisplay(String CategoryID,String CategoryName){

        Map<String, SubProductClass> TempSubProducts;
        ProductDataLoader PDL = new ProductDataLoader();
        TempSubProducts = PDL.getSubProducts();

        Map<String, String> UserChoiceSubProducts = new HashMap<>();

        int CategoryCounter = 0;

        for (String a : TempSubProducts.keySet()){
            SubProductClass SPC = TempSubProducts.get(a);

            String CategoryIDD = SPC.getCategoryID();
            String SubProductName = SPC.getSubProductName();

            if (CategoryIDD.equals(CategoryID)){
                UserChoiceSubProducts.put(a, SubProductName);
                CategoryCounter++;
            }
        }

        while(true) {
            System.out.println("\n--------------------------------");
            System.out.println("       Sub Product Menu         ");
            System.out.println("--------------------------------");
            int Counter = 0;

            for (String key : UserChoiceSubProducts.keySet()) {
                Counter++;
                System.out.println(Counter+": "+UserChoiceSubProducts.get(key));
            }

            System.out.println("--------------------------------");

            Scanner sc = new Scanner(System.in);
            System.out.println("To Go Back To Category Menu, Enter -> 'b'");
            System.out.print("Enter Your Choice: ");

            if(!sc.hasNext()){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            String TempChoice = sc.nextLine().toLowerCase();

            if(TempChoice.equals("b")){
                return 1;
            }

            int Choice = 0;

            try{

                Choice = Integer.parseInt(TempChoice);

            } catch(Exception e){
                System.out.println("\nPlease Enter Valid Input!\n");
                continue;
            }

            if(Choice < 1 || Choice > CategoryCounter){
                System.out.println("\nPlease Select a Valid Number! between 1 to "+CategoryCounter+"!\n");
                continue;
            }
            System.out.println(CategoryCounter);
            String UserSelectedSubProductId = "";
            String UserSelectedSubProductName = "";

            int Temp = 0;

            for(String a :UserChoiceSubProducts.keySet()) {
                Temp++;
                if(Choice == Temp) {
                    UserSelectedSubProductId = a;
                    UserSelectedSubProductName = UserChoiceSubProducts.get(a);
                }
            }

            int result = ProductShopingProduct.ProductShopingProductDisplay(CategoryID,CategoryName,UserSelectedSubProductId,UserSelectedSubProductName);

            if(result == 0){
                return 0;
            }
        }
    }
}
