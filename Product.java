package com.samitha;

// Product.java
public class Product {
    private String name;
    private double price;
    private boolean available;

    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Availability: " + (available ? "In Stock" : "Out of Stock");
    }
}
