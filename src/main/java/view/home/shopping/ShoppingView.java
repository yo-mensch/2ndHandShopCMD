package view.home.shopping;

import service.UserService;
import view.Controller;
import view.home.shopping.handlers.AvailableProductHandler;
import view.home.shopping.handlers.ShoppingCartHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingView {
    private UserService userService;
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private AvailableProductHandler availableProductHandler;
    private ShoppingCartHandler shoppingCartHandler;

    public ShoppingView(UserService userService,Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
        shoppingCartHandler = new ShoppingCartHandler(userService,scanner);
        availableProductHandler = new AvailableProductHandler(userService,scanner);
        addCommands();
        this.controller = new Controller(commands);
    }
    private void addCommands() {
        commands = new HashMap();
        commands.put("1", shoppingCartHandler);
        commands.put("2",availableProductHandler);
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

    public void printMenu(){
        System.out.println("------------------");
        System.out.println("1 - View your cart");
        System.out.println("2 - View available products");
        System.out.println("0 - Exit this menu");
    }
}
