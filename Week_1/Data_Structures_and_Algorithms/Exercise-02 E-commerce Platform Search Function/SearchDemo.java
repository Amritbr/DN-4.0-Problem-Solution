import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(102, "Keyboard", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(104, "Monitor", "Electronics"),
            new Product(103, "T-shirt", "Fashion")
        };

        int searchId = 104;

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, searchId);
        System.out.println(result1 != null ? result1 : "Product not found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        System.out.println("Binary Search (after sorting):");
        Product result2 = binarySearch(products, searchId);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}