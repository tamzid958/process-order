package org.ecommerce;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        InventoryService inventory = new InventoryService();
        OrderService orderService = new OrderService(db, inventory);

        inventory.addProduct(1, "Laptop", 2);
        inventory.addProduct(2, "Phone", 5);
        inventory.addProduct(3, "Tablet", 0);

        orderService.placeOrder(101, 1, 1);
        orderService.placeOrder(102, 2, 3);

        System.out.println("\n=== ORDER HISTORY REPORT ===");
        orderService.printOrderHistory(101);

        System.out.println("\n=== BULK ORDER PROCESSING ===");
        int[][] bulkOrders = {
                {103, 1, 1}, {104, 2, 2}, {105, 2, 4}, {106, 3, 1}
        };
        orderService.processBulkOrders(bulkOrders);

        System.out.println("\n=== LOW STOCK ALERTS ===");
        inventory.checkLowStock(2);

        System.out.println("\n=== CANCEL ORDER ===");
        orderService.cancelOrder(102);
    }
}