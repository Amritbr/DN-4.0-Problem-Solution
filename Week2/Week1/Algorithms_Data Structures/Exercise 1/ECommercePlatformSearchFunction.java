// Algorithms Data Structures
// Exercise 1: E-commerce Platform Search Function

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit; // For measuring execution time

// Represents a product in an e-commerce catalog.

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}


// Provides search functionalities for products using Linear and Binary Search algorithms.
// Includes methods for demonstrating and analyzing their performance.

public class ECommercePlatformSearchFunction {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents potential overflow
            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Main Method

    public static void main(String[] args) {
        
        // Sample Products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Backpack", "Bags"),
            new Product(6, "Tablet", "Electronics"),
            new Product(7, "Keyboard", "Electronics"),
            new Product(8, "Mouse", "Electronics"),
            new Product(9, "Headphones", "Audio"),
            new Product(10, "Monitor", "Electronics")
        };
        String searchTarget = "Phone";

        // Search Algorithms
        System.out.println("Search Demonstration (Small Dataset)");

        // Linear Search
        Product foundLinear = linearSearch(products, searchTarget);
        System.out.println("Linear Search for '" + searchTarget + "': " + (foundLinear != null ? foundLinear : "Not Found"));

        // Binary Search requires a sorted array. Let's create a sorted copy for demonstration.
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product foundBinary = binarySearch(sortedProducts, searchTarget);
        System.out.println("Binary Search for '" + searchTarget + "': " + (foundBinary != null ? foundBinary : "Not Found"));

        // Performance Analysis with a Large Dataset
        System.out.println("\nPerformance Analysis (Large Dataset)");

        int largeDatasetSize = 100000; // 100,000 products
        Product[] largeProductsForLinear = new Product[largeDatasetSize];

        // Create products for linear search. Put the target in the middle.
        for (int i = 0; i < largeDatasetSize; i++) {
            largeProductsForLinear[i] = new Product(i, "Item_" + i, "Generic");
        }
        largeProductsForLinear[largeDatasetSize / 2] = new Product(999999, "PerformanceTarget", "Special");
        String performanceTarget = "PerformanceTarget";

        // For Binary Search, create a separate array and sort it once beforehand
        Product[] largeProductsForBinary = new Product[largeDatasetSize];
        for (int i = 0; i < largeDatasetSize; i++) {
            largeProductsForBinary[i] = new Product(i, "Item_" + i, "Generic");
        }
        largeProductsForBinary[largeDatasetSize / 2] = new Product(999999, "PerformanceTarget", "Special");
        // Sort once for binary search
        Arrays.sort(largeProductsForBinary, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Measure Linear Search Time
        long startTimeLinear = System.nanoTime();
        linearSearch(largeProductsForLinear, performanceTarget);
        long endTimeLinear = System.nanoTime();
        long durationLinearMs = TimeUnit.NANOSECONDS.toMillis(endTimeLinear - startTimeLinear);
        System.out.println(String.format("Linear Search (%d items): %d ms", largeDatasetSize, durationLinearMs));

        // Measure Binary Search Time (on pre-sorted array)
        long startTimeBinary = System.nanoTime();
        binarySearch(largeProductsForBinary, performanceTarget);
        long endTimeBinary = System.nanoTime();
        long durationBinaryMs = TimeUnit.NANOSECONDS.toMillis(endTimeBinary - startTimeBinary);
        System.out.println(String.format("Binary Search (%d items, pre-sorted): %d ms", largeDatasetSize, durationBinaryMs));
    }
}