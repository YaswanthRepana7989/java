//ProductManagementSystem

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Product {
    private String name;
    private double price;
    private double rating;
    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getRating() {
        return rating;
    }
    public void displayProduct() {
        System.out.printf("Name: %s | Price: %.2f | Rating: %.1f\n", name, price, rating);
    }
}
class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added successfully!");
    }
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Product List:");
        for (Product p : products) {
            p.displayProduct();
        }
    }
    public void sortByPrice() {
        if (products.isEmpty()) {
            System.out.println("No products to sort.");
            return;
        }
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Products sorted by price (Low to High).");
        listProducts();
    }
    public void sortByRating() {
        if (products.isEmpty()) {
            System.out.println("No products to sort.");
            return;
        }
        Collections.sort(products, Comparator.comparingDouble(Product::getRating).reversed());
        System.out.println("Products sorted by rating (High to Low).");
        listProducts();
    }
}
public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        int choice;

        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Sort by Price");
            System.out.println("4. Sort by Rating");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product rating (0.0 - 5.0): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    manager.addProduct(new Product(name, price, rating));
                    break;
                case 2:
                    manager.listProducts();
                    break;
                case 3:
                    manager.sortByPrice();
                    break;
                case 4:
                    manager.sortByRating();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}


/* Output:
--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 1
Enter product name: laptop
Enter product price: 55000
Enter product rating (0.0 - 5.0): 4
Product added successfully!

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 1
Enter product name: mobile oneplus
Enter product price: 46000
Enter product rating (0.0 - 5.0): 4.9
Product added successfully!

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 1
Enter product name: smart watch
Enter product price: 2500
Enter product rating (0.0 - 5.0): 5
Product added successfully!

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 2
Product List:
Name: laptop | Price: 55000.00 | Rating: 4.0
Name: mobile oneplus | Price: 46000.00 | Rating: 4.9
Name: smart watch | Price: 2500.00 | Rating: 5.0

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 3
Products sorted by price (Low to High).
Product List:
Name: smart watch | Price: 2500.00 | Rating: 5.0
Name: mobile oneplus | Price: 46000.00 | Rating: 4.9
Name: laptop | Price: 55000.00 | Rating: 4.0

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 4
Products sorted by rating (High to Low).
Product List:
Name: smart watch | Price: 2500.00 | Rating: 5.0
Name: mobile oneplus | Price: 46000.00 | Rating: 4.9
Name: laptop | Price: 55000.00 | Rating: 4.0

--- Product Management System ---
1. Add Product
2. List Products
3. Sort by Price
4. Sort by Rating
5. Exit
Enter choice: 5
Exiting program.
*/
