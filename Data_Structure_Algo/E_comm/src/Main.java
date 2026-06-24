public class Main {
    public static void main(String[] args) {

        // Array for Linear Search (unsorted)
        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(103, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(102, "Bag", "Fashion")
        };

        Product linearResult =
                SearchOperations.LinearSearch(products, 104);

        System.out.println("Linear Search Result:");
        System.out.println(linearResult);

        // Sorted Array for Binary Search
        Product[] sortedProducts = {
                new Product(101, "Shoes", "Fashion"),
                new Product(102, "Bag", "Fashion"),
                new Product(103, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Laptop", "Electronics")
        };

        Product binaryResult =
                SearchOperations.BinarySearch(sortedProducts, 104);

        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult);
    }
}