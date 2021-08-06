package view.home;

import service.UserService;
import view.Controller;
import view.home.handlers.ProductHandler;
import view.home.handlers.ShoppingHandler;
import view.home.handlers.UserInfoHandler;
import view.home.user_info.handlers.BoughtProductHandler;
import view.printer.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeView {
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private UserInfoHandler userInfoHandler;
    private ProductHandler productHandler;
    private ShoppingHandler shoppingHandler;
    private BoughtProductHandler boughtProductHandler;

    public HomeView(UserInfoHandler userInfoHandler, ProductHandler productHandler, ShoppingHandler shoppingHandler,BoughtProductHandler boughtProductHandler, Scanner scanner) {
        this.scanner = scanner;
        this.userInfoHandler = userInfoHandler;
        this.productHandler = productHandler;
        this.shoppingHandler = shoppingHandler;
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands(){
        commands = new HashMap();
        commands.put("1",userInfoHandler);
        commands.put("2", productHandler);
        commands.put("3", shoppingHandler);
        commands.put("4",boughtProductHandler);
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

    private void printMenu(){
        Printer.printMainMenu();
    }
}
