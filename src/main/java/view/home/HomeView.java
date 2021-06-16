package view.home;

import service.UserService;
import view.Controller;
import view.home.handlers.ProductHandler;
import view.home.handlers.UserInfoHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeView {
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private UserInfoHandler userInfoHandler;
    private ProductHandler productHandler;
    private UserService userService;

    public HomeView(UserService userService, Scanner scanner) {
        this.scanner = scanner;
        userInfoHandler = new UserInfoHandler(userService, scanner);
        productHandler = new ProductHandler();
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands(){
        commands = new HashMap();
        commands.put("1",userInfoHandler);
        commands.put("2", productHandler);
        //commands.put("3", shoppingHandler);
    }

    private void printMenu(){
        System.out.println("-----Logged In-----");
        System.out.println("1 - Edit user info");
        System.out.println("2 - Manage my products");
        System.out.println("3 - Go to shop");
        System.out.println("0 - Log out");
    }

    public void run(){
        printMenu();
        String userInput = "";
        do {
            userInput = scanner.nextLine();

            if(!userInput.equals("0")){
                controller.handleUserInput(userInput);
            }

            printMenu();
        } while(!userInput.equals("0"));
    }
}
