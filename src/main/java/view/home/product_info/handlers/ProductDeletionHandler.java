package view.home.product_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class ProductDeletionHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public ProductDeletionHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        printWarning();
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        userService.deleteProductForSale(productName);
    }

    public void printWarning(){
        System.out.println("------------WARNING------------");
        System.out.println("You're about to delete a product");
        System.out.println("This action cannot be undone.");
        System.out.println("-------------------------------");
    }
}
