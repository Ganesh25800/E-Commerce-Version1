package ProductShopping.FileClasses;

public class SubProductClass {
    private String SubProductName;
    private String CategoryID;

    public SubProductClass() {}

    public SubProductClass(String SubProductName, String CategoryID) {
        this.SubProductName = SubProductName;
        this.CategoryID = CategoryID;
    }

    public String getSubProductName() {return SubProductName;}
    public String getCategoryID() {return CategoryID;}

    public void setSubProductName(String SubProductName) {this.SubProductName = SubProductName;}
    public void setCategoryID(String CategoryID) {this.CategoryID = CategoryID;}


}
