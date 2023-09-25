package com.samitha;

class CartItem {
    private final Product product;
    private int quantity;
    private final DiscountStrategy discountStrategy;

    public CartItem(Product product, int quantity, DiscountStrategy discountStrategy) {
        this.product = product;
        this.quantity = quantity;
        this.discountStrategy = discountStrategy;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return discountStrategy.applyDiscount(product.getPrice(), quantity);
    }

    @Override
    public String toString() {
        return quantity + " " + product.getName();
    }
}
