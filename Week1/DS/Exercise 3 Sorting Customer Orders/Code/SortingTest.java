public class SortingTest {
    public static void main(String[] args) {
        // Initial array of orders
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.20),
            new Order("O004", "Diana", 120.00)
        };

        // Test Bubble Sort
        System.out.println("Bubble Sort:");
        Order[] bubbleSortedOrders = orders.clone(); // Clone to avoid modifying the original array
        BubbleSort.bubbleSort(bubbleSortedOrders);
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Reinitialize orders array for Quick Sort test
        Order[] quickSortedOrders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.20),
            new Order("O004", "Diana", 120.00)
        };

        // Test Quick Sort
        System.out.println("\nQuick Sort:");
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
