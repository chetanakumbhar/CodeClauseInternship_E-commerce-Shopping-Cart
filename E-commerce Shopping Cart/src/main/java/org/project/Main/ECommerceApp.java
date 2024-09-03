package org.project.Main;

import org.project.Bean.Product;
import org.project.DAO.CartDAO;
import org.project.DAO.ProductDAO;

import java.util.List;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        ProductDAO productDAO = new ProductDAO();
        CartDAO cartDAO = new CartDAO();

        List<Product> products = productDAO.getAllProducts();

        while (true) {
            System.out.println("\nWelcome to the E-commerce Shopping Cart");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product Catalog:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter the product ID to add to cart: ");
                    int productIdToAdd = scanner.nextInt();
                    cartDAO.addProductToCart(productIdToAdd);
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    System.out.print("Enter the product ID to remove from cart: ");
                    int productIdToRemove = scanner.nextInt();
                    cart.removeProduct(products.get(productIdToRemove - 1));
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
