package com.samitha;

class PercentageDiscountStrategy implements DiscountStrategy {
    private double discountPercentage;

    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price, int quantity) {
        // Implement the discount calculation based on both price and quantity
        return (price * quantity) - ((price * quantity) * discountPercentage / 100);
    }
}