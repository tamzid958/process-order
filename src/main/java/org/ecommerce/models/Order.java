package org.ecommerce.models;

public class Order {
    private int orderId;
    private int userId;
    private int productId;
    private int quantity;

    public Order(int orderId, int userId, int productId, int quantity) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() { return orderId; }
    public int getUserId() { return userId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
