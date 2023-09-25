package com.samitha;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(Product product, int quantity, DiscountStrategy discountStrategy) {
        cartItems.add(new CartItem(product, quantity, discountStrategy));
    }

    public void updateQuantity(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(newQuantity); // Use the correct setter method
                break;
            }
        }
    }


    public List<CartItem> getCartItems() {
        return cartItems;
    }


    public void removeItem(Product product) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().equals(product)) {
                iterator.remove();
                break;
            }
        }
    }

    public double getTotalBill() {
        double totalBill = 0;
        for (CartItem item : cartItems) {
            totalBill += item.getTotalPrice();
        }
        return totalBill;
    }

    public void displayCart() {
        System.out.println("Cart Items:");
        for (CartItem item : cartItems) {
            System.out.println(item.getQuantity() + " x " + item.getProduct().getName() +
                    " - Total Price: $" + item.getTotalPrice());
        }
    }
}
