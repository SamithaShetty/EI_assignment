package com.samitha;

class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, int quantity) {
        // Implement the Buy One, Get One Free discount logic based on quantity
        int eligibleQuantity = quantity / 2; // Calculate eligible items for discount
        return price * (quantity - eligibleQuantity); // Apply discount
    }
}
