import java.util.HashMap;
public class InventoryManager {
    private HashMap<Integer, Product> inventory;
    public InventoryManager(){
        inventory=new HashMap<>();
    }
    public void addProduct(Product product){
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added");
    }
    public void updateProduct(int productId, int quantity, double price){
        if(inventory.containsKey(productId)){
            Product product=inventory.get(productId);
            product.SetQuantity(quantity);
            product.SetPrice(price);

            System.out.println("Product added");
        }
        else{
            System.out.println("Product Not Found!");
        }
    }
    public void deleteProduct(int productId){
        if(inventory.containsKey(productId)){
            inventory.remove(productId);
            System.out.println("Product Deleted");
        }
        else{
            System.out.println("Product Not Found!");
        }
    }
    public void displayProducts() {

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}


