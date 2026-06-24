
public class Product {
    int productId;
    String productName;
    String Category;

    public Product(int productId, String productName, String Category){
        this.productId=productId;
        this.productName=productName;
        this.Category=Category;
    }
    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Category: " + Category;
    }

}
