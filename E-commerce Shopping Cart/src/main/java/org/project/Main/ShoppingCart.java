package org.project.Main;

import org.project.Bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public void removeProduct(Product product) {
        if (cartItems.remove(product)) {
            System.out.println(product.getName() + " removed from the cart.");
        } else {
            System.out.println(product.getName() + " is not in the cart.");
        }
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart contains:");
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    public void checkout() {
        double total = calculateTotal();
        if (total > 0) {
            System.out.println("Your total is $" + total + ". Proceeding to checkout...");
            // Add payment processing logic here
            System.out.println("Thank you for your purchase!");
            cartItems.clear(); // Empty the cart after purchase
        } else {
            System.out.println("Your cart is empty. Add items before checkout.");
        }
    }
}
