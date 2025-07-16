package ProductShopping.FileClasses;

public class ProductClass {
    private String ProductID;
    private String SubProductID;
    private String ProductName;
    private String ProductSize;
    private String ProductPrice;
    private String ProductAvailability;
    private String Gender;

    public ProductClass() {}

    public ProductClass(String ProductID, String SubProductID, String ProductName, String ProductSize,
                        String ProductPrice, String ProductAvailability, String Gender) {
        this.ProductID = ProductID;
        this.SubProductID = SubProductID;
        this.ProductName = ProductName;
        this.ProductSize = ProductSize;
        this.ProductPrice = ProductPrice;
        this.ProductAvailability = ProductAvailability;
        this.Gender = Gender;
    }
    public String getProductID() {return ProductID;}
    public String getSubProductID() {return SubProductID;}
    public String getProductName() {return ProductName;}
    public String getProductSize() {return ProductSize;}
    public String getProductPrice() {return ProductPrice;}
    public String getProductAvailability() {return ProductAvailability;}
    public String getGender() {return Gender;}

    public void setProductID(String ProductID) {this.ProductID = ProductID;}
    public void setSubProductID(String SubProductID) {this.SubProductID = SubProductID;}
    public void setProductName(String ProductName) {this.ProductName = ProductName;}
    public void setProductSize(String ProductSize) {this.ProductSize = ProductSize;}
    public void setProductPrice(String ProductPrice) {this.ProductPrice = ProductPrice;}
    public void setProductAvailability(String ProductAvailability) {this.ProductAvailability = ProductAvailability;}
    public void setGender(String Gender) {this.Gender = Gender;}

    @Override
    public String toString() {
        return "ProductID: " + ProductID +
                ", Brand: " + ProductName +
                ", Size: " + ProductSize +
                ", Price: " + ProductPrice +
                ", Availability: " + ProductAvailability +
                ", Gender: " + Gender;
    }

}
