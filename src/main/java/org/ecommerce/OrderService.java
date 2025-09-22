package org.ecommerce;

import org.ecommerce.models.Order;

import java.util.List;

public class OrderService {

    private Database db;
    private InventoryService inventoryService;

    public OrderService(Database db, InventoryService inventoryService) {
        this.db = db;
        this.inventoryService = inventoryService;
    }

    public String placeOrder(int userId, int productId, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity: " + quantity);
        }

        int stock = inventoryService.getStock(productId);

        if (stock >= quantity) {
            inventoryService.updateStock(productId, stock - quantity);
        }

        db.saveOrder(userId, productId, quantity);
        System.out.println("Order placed: user=" + userId + ", product=" + productId + ", qty=" + quantity);

        return "SUCCESS";
    }

    public void printOrderHistory(int userId) {
        List<Order> orders = db.getOrdersForUser(userId);
        for (Order o : orders) {
            System.out.println("OrderID: " + o.getOrderId() + ", Product: " +
                    inventoryService.getProductName(o.getProductId()) +
                    ", Qty: " + o.getQuantity() +
                    ", Remaining Stock: " + inventoryService.getStock(o.getProductId()));
        }
    }

    public void processBulkOrders(int[][] orders) {
        // TODO: implement bulk processing
    }

    public void cancelOrder(int orderId) {
        // TODO: implement cancellation
    }
}
