package org.ecommerce;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Integer, Integer> stockMap = new HashMap<>();
    private Map<Integer, String> productMap = new HashMap<>();

    public void addProduct(int productId, String name, int stock) {
        productMap.put(productId, name);
        stockMap.put(productId, stock);
    }

    public int getStock(int productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    public void updateStock(int productId, int newStock) {
        stockMap.put(productId, newStock);
    }

    public String getProductName(int productId) {
        return productMap.get(productId);
    }

    public void checkLowStock(int threshold) {
        // TODO: implement
    }
}
