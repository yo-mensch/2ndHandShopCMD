package model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private User author;
    private float price;
    private boolean isBought;

    public Product(String name, String description, float price, User author) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.isBought = false;
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public User getAuthor() { return author; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public boolean isBought() {
        return isBought;
    }

    public void setBoughtStatus(boolean bought) {
        isBought = bought;
    }
}
