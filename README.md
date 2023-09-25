# E-Commerce Cart System

This Java program, ECommerceCartSystem, is a simple command-line-based e-commerce shopping cart system. It allows users to interact with the system to perform various shopping cart operations, such as adding items to the cart, updating quantities, removing items, viewing the cart contents, and checking out. The program is designed with object-oriented principles and uses interfaces and classes to represent products, discount strategies, and the shopping cart.

## Prerequisites

Before running the program, make sure you have the following:

* Java Development Kit (JDK) installed on your system.
* An Integrated Development Environment (IDE) or a command-line interface to run Java programs.

## Getting Started

  1. Clone or download the repository from GitHub.

  2. Open the project in your preferred Java development environment.

  3. Compile and run the Main.java file to start the Satellite Command System.

To compile the program using the command line, use the following command:
```bash
javac ECommerceCartSystem.java
```
To run the program using the command line, use the following command:
```bash
java ECommerceCartSystem
```
## Features

  1. **Add Items to Cart**: Users can add products to the shopping cart by specifying the product name and quantity.

  2. **Update Quantity**: Users can update the quantity of items in the cart based on the product name.

  3. **Remove Items from Cart**: Items can be removed from the cart by specifying the product name.

  4. **View Cart Contents**: Users can view the current contents of the shopping cart.

  5. **Checkout**: The program calculates and displays the total bill for items in the cart, considering any applicable discounts.

  6. **Exit**: Users can exit the program at any time.

## Usage

  1. Run the program, and it will display a list of available products with their names, prices, and availability.

  2. Choose from the menu options by entering the corresponding number to perform actions like adding items to the cart, updating quantities, removing items, viewing the cart, checking out, or exiting.

## Code Structure

The code is organised into several classses:

  - **Product Class**: Represents a product with attributes such as name, price, and availability.

  - **DiscountStrategy Interface**: Defines different discount strategies for products.

  - **PercentageDiscountStrategy Class**: Implements a percentage-based discount strategy.

  - **CartItem Class**: Represents an item in the shopping cart, including the product, quantity, and discount strategy.

  - **ShoppingCart Class**: Manages the shopping cart, allowing users to add, update, remove items, and calculate the total bill.

  - **ECommerceCartSystem Class (Main)**: Provides a simple command-line interface for users to interact with the shopping cart system.

## Error Handling

The E-Commerce Cart System incorporates error handling to provide a smoother user experience and prevent program crashes in case of unexpected input. The primary error that is handled in the program is the `InputMismatchException`, which can occur when the program attempts to read input of one data type but receives input of a different, incompatible type.

When the user enters input that cannot be interpreted as an integer (e.g., entering a non-numeric character or a floating-point number), the program catches the `InputMismatchException` and takes the following actions:

  - Displays an error message to inform the user that the input was invalid.
  - Consumes the invalid input to prevent an infinite loop due to the same invalid input being repeatedly processed.
  - Allows the user to reattempt their input.

This error handling ensures that the program gracefully handles cases of invalid user input, preventing crashes and providing clear feedback to the user to enter a valid choice.

While `InputMismatchException` handling is the primary error management approach, it's important to note that this program is designed for educational purposes and may require additional error handling and validation for a production environment.

## Author

  - [SamithaShetty](https://github.com/SamithaShetty)

## License
This project is licensed under the MIT License - see the [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository) file for details. 
