package view.home.product_info;

import service.UserService;
import view.Controller;
import view.home.product_info.handlers.ProductAdditionHandler;
import view.home.product_info.handlers.ProductDeletionHandler;
import view.home.product_info.handlers.ProductListHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductInfoView {
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private UserService userService;
    private ProductAdditionHandler productAdditionHandler;
    private ProductDeletionHandler productDeletionHandler;
    private ProductListHandler productListHandler;

    public ProductInfoView(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
        productAdditionHandler = new ProductAdditionHandler(this.userService,scanner);
        productDeletionHandler = new ProductDeletionHandler(this.userService,scanner);
        productListHandler = new ProductListHandler(this.userService,scanner);
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands() {
        commands = new HashMap();
        commands.put("1", productAdditionHandler);
        commands.put("2",productDeletionHandler);
        commands.put("3",productListHandler);
    }

    public void run(){
        printMenu();
        String userInput = "";
        do {
            userInput = scanner.nextLine();

            if(!userInput.equals("0")&&!userInput.equals("4")){
                controller.handleUserInput(userInput);
            }

            printMenu();
        } while(!userInput.equals("0"));
    }

    private void printMenu() {
        System.out.println("1 - Add new product");
        System.out.println("2 - Delete product");
        System.out.println("3 - View your products");
        System.out.println("0 - Exit this menu");
    }


}
