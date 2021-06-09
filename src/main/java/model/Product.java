package model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private float price;

    public Product(String name, String description, float price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
