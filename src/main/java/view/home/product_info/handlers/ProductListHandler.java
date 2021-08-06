package view.home.product_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

import java.util.Scanner;

public class ProductListHandler implements Handler {
    private UserService userService;
    private Scanner scanner;
    public ProductListHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }
    @Override
    public void execute(){
        Printer.printMessage("---Your products---");
        printProducts();
    }

    public void printProducts(){
        Printer.printProductArray(userService.getProductsForSale());
    }
}
