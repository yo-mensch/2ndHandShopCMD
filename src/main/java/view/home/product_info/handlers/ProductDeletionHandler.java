package view.home.product_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

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
        Printer.printMessage("Enter product name: ");
        String productName = scanner.nextLine();
        userService.deleteProductForSale(productName);
    }

    public void printWarning(){
        Printer.printWarning();
    }
}
