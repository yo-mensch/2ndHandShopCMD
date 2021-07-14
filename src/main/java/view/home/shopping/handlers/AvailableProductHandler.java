package view.home.shopping.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class AvailableProductHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public AvailableProductHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if(isShopEmpty()){
            System.out.println("--------------");
            System.out.println("Shop is empty!");
            System.out.println("--------------");
        } else {
            printAvailableProducts();
        }
    }

    private boolean isShopEmpty(){
        if(userService.getAvailableProducts().size() == 0)
            return true;

        return false;
    }

    private void printAvailableProducts(){
        int index = 0;
        System.out.println("----------------");
        for(Product product : userService.getAvailableProducts()){
            index++;
            System.out.println(index + ". " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("----------------");
        }
    }
}
