package ProductShopping;

import ProductShopping.FileClasses.ProductClass;

import java.util.*;

public class ProductShopingProduct {

    public static int ProductShopingProductDisplay(String CategoryID, String CategoryName, String UserSelectedSubProductID,
                                                    String UserSelectedSubProductName) {

            Map<String, List<ProductClass>> TempProduct;
            ProductDataLoader PDL = new ProductDataLoader();
            TempProduct = PDL.getProducts();


            List<ProductClass> ProductList = new ArrayList<>();

            for(String a : TempProduct.keySet()){
                List<ProductClass> Products = TempProduct.get(a);

                for(int index = 0; index < Products.size(); index++){

                    ProductClass p = Products.get(index);
                    String ClassSubProductID = p.getSubProductID();

                    if(ClassSubProductID.equals(UserSelectedSubProductID)){
                        ProductList.add(p);
                    }

                }
            }


        while(true){
            System.out.println("\nHere are the Products List of "+CategoryName);
            System.out.println("Found "+ProductList.size()+" Products in "+UserSelectedSubProductName+"\n");
            System.out.println("-----------------------------------------");

            int counter = 0;
            for(int index = 0; index < ProductList.size(); index++){
                ProductClass p = ProductList.get(index);
                System.out.println((index + 1) + ". Brand : " + p.getProductName());
                System.out.println("   Availability : " + p.getProductAvailability());
                System.out.println("   Size : " + p.getProductSize());
                System.out.println("   Gender : " + p.getGender());
                System.out.println("   Price : " + p.getProductPrice());

                System.out.println("---------------------------------------");
            }

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

            if(Choice < 1 || Choice > ProductList.size()){
                System.out.println("\nPlease Select a Valid Number! between 1 to "+ProductList.size()+"!\n");
                continue;
            }

            ProductClass selected = ProductList.get(Choice-1);

            int result = ProductConfirmation.ProductConfirmationBeforeAddingToCart(CategoryID,CategoryName,UserSelectedSubProductID,
                                                                        UserSelectedSubProductName,selected);

            if(result == 0){
                return 0;
            }
        }
    }
}
