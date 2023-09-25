package com.samitha;

// DiscountStrategy interface defines different discount strategies
interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}