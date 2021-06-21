package view.home.product_info.handlers;

import service.UserService;
import view.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductInfoView {
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private UserService userService;

    public ProductInfoView(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands() {
        commands = new HashMap();
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
        System.out.println("1 - View your products");
        System.out.println("2 - Add new product");
        System.out.println("3 - Delete product");
        System.out.println("0 - Exit this menu");
    }


}
