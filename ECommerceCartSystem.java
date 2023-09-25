package com.samitha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ECommerceCartSystem {
    public static void main(String[] args) {
        // Create some sample products
        Product laptop = new Product("Laptop", 1000, true);
        Product headphones = new Product("Headphones", 50, true);
        Product smartphone = new Product("Smartphone", 800, true);
        Product mouse = new Product("Mouse", 20, true);

        // Create a shopping cart with a percentage discount strategy
        DiscountStrategy discountStrategy = new PercentageDiscountStrategy(10); // 10% discount
        ShoppingCart cart = new ShoppingCart();

        // Provide a simple command-line interface for the user
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearConsole();
            printInBox("Welcome to the E-commerce Cart System");
            printInBox("Available Products:");
            System.out.println(laptop.toString());
            System.out.println(headphones.toString());
            System.out.println(smartphone.toString());
            System.out.println(mouse.toString());

            printInBox("Menu");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        Product selectedProduct = null;

                        // Find the selected product
                        if (productName.equalsIgnoreCase("Laptop")) {
                            selectedProduct = laptop;
                        } else if (productName.equalsIgnoreCase("Headphones")) {
                            selectedProduct = headphones;
                        } else if (productName.equalsIgnoreCase("Smartphone")) {
                            selectedProduct = smartphone;
                        } else if (productName.equalsIgnoreCase("Mouse")) {
                            selectedProduct = mouse;
                        } else {
                            printInBox("Invalid product name. Product not added to cart.");
                            continue;
                        }

                        cart.addItem(selectedProduct, quantity, discountStrategy);
                        printInBox("Item added to cart.");
                        break;
                    case 2:
                        System.out.print("Enter product name to update quantity: ");
                        String updateProductName = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        Product productToUpdate = null;

                        // Find the product to update
                        for (CartItem item : cart.getCartItems()) {
                            if (item.getProduct().getName().equalsIgnoreCase(updateProductName)) {
                                productToUpdate = item.getProduct();
                                break;
                            }
                        }

                        if (productToUpdate != null) {
                            cart.updateQuantity(productToUpdate, newQuantity);
                            printInBox("Quantity updated.");
                        } else {
                            printInBox("Product not found in the cart. Quantity not updated.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter product name to remove from cart: ");
                        String removeProductName = scanner.nextLine();
                        Product productToRemove = null;

                        // Find the product to remove
                        for (CartItem item : cart.getCartItems()) {
                            if (item.getProduct().getName().equalsIgnoreCase(removeProductName)) {
                                productToRemove = item.getProduct();
                                break;
                            }
                        }

                        if (productToRemove != null) {
                            cart.removeItem(productToRemove);
                            printInBox("Item removed from cart.");
                        } else {
                            printInBox("Product not found in the cart. Item not removed.");
                        }
                        break;
                    case 4:
                        clearConsole();
                        printInBox("Cart Contents");
                        cart.displayCart();
                        break;
                    case 5:
                        clearConsole();
                        printInBox("Checkout");
                        cart.displayCart();
                        System.out.println("Total Bill: Your total bill is $" + cart.getTotalBill() + ".");
                        break;
                    case 6:
                        printInBox("Exiting program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        printInBox("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Consume the invalid input
                printInBox("Invalid input. Please enter a valid menu choice.");
            }


        }
    }

    // Utility method to print content inside a box
    private static void printInBox(String content) {
        int contentLength = content.length();
        String border = "+" + "-".repeat(contentLength + 2) + "+";
        String padding = "| " + content + " |";

        System.out.println(border);
        System.out.println(padding);
        System.out.println(border);
    }

    // Utility method to clear the console (for Windows and Unix-like systems)
    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console: " + e.getMessage());
        }
    }
}
