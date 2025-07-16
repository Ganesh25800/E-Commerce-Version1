package ProductShopping;

import ProductShopping.FileClasses.ProductClass;
import ProductShopping.FileClasses.SubProductClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductDataLoader {
    public Map<String,String> category;
    public Map<String, SubProductClass> subProducts;
    public Map<String, List<ProductClass>> Products;

    public ProductDataLoader() {
        category = new HashMap<>();
        subProducts = new HashMap<>();
        Products = new HashMap<>();

        loadCategoryFile();
        loadSubProductFile();
        loadProductFile();

    }


    public Map<String,String> getCategory() {
        return category;
    }
    public Map<String, SubProductClass> getSubProducts() {
        return subProducts;
    }
    public Map<String, List<ProductClass>> getProducts() {
        return Products;
    }


    void loadProductFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/newproduct.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                // Skip invalid lines
                if (data.length < 6 || data.length > 7) continue;

                String productID = data[0];
                String subProductID = data[1];
                String productName = data[2];
                String productSize = "";  // Default empty
                String productPrice;
                String productAvailability;
                String productGender;

                if (data.length == 7) {
                    // Row has size field
                    productSize = data[3];
                    productPrice = data[4];
                    productAvailability = data[5];
                    productGender = data[6];
                } else {
                    // Row without size field
                    productPrice = data[3];
                    productAvailability = data[4];
                    productGender = data[5];
                }

                if (!subProducts.containsKey(subProductID)) continue;

                ProductClass pc = new ProductClass();
                pc.setProductID(productID);
                pc.setSubProductID(subProductID);
                pc.setProductName(productName);
                pc.setProductSize(productSize);
                pc.setProductPrice(productPrice);
                pc.setProductAvailability(productAvailability);
                pc.setGender(productGender);

                Products.computeIfAbsent(subProductID, k -> new ArrayList<>()).add(pc);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadSubProductFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/subproduct.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String SubProductID = data[0];
                String SubProductName = data[1];
                String CategoryID = data[2];

                if(category.containsKey(CategoryID)) {
                    SubProductClass SPC = new SubProductClass(SubProductName,CategoryID);

                    subProducts.put(SubProductID,SPC);
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCategoryFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/category.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                category.put(data[0],data[1]);
            }
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
