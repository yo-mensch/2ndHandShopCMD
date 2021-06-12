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

    public UUID getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }
}
