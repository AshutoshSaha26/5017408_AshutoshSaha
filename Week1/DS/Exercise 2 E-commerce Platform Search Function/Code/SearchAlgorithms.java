public class SearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId().equals(productId)) {
                return products[mid];
            }
            if (productId.compareTo(products[mid].getProductId()) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; // Product not found
    }
}
