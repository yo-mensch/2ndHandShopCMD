package view.home.product_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

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
        System.out.println("---Your products---");
        printProducts();
    }

    public void printProducts(){
        int index = 0;
        for(Product product : userService.getProductsForSale()){
            index++;
            System.out.println(index + ". " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("----------------");
        }
    }
}
