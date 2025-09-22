package org.ecommerce;

import org.ecommerce.models.Order;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public void saveOrder(int userId, int productId, int quantity) {
        orders.add(new Order(orderCounter++, userId, productId, quantity));
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getOrdersForUser(int userId) {
        List<Order> list = new ArrayList<>();
        for (Order o : orders) {
            if (o.getUserId() == userId) {
                list.add(o);
            }
        }
        return list;
    }

    public void removeOrder(int orderId) {
        // TODO: implement cancellation
    }
}
