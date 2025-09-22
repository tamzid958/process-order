package org.ecommerce.models;

public class Product {
    private int productId;
    private String name;

    public Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
}
