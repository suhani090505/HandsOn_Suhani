

public class SearchOperations {

    //Linear Search
    public static Product LinearSearch(Product[] products, int targetId){
        for(Product product:products){
            if(product.productId== targetId){
                return product;
            }

        }
        return null;
    }

    //Binary Search
    public static Product BinarySearch(Product[] products, int targetId){
        int left=0;
        int right= products.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(products[mid].productId==targetId)
                return products[mid];
            else if(products[mid].productId>targetId){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return null;

    }
}
