package model;

import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    private UUID id;
    private List<Product> products;
    private float totalPrice;

    public ShoppingCart(List<Product> products, float totalPrice) {
        this.id = UUID.randomUUID();
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}