package view.main;

import service.ShopService;
import view.Controller;
import view.main.handlers.LoginHandler;
import view.main.handlers.RegisterHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private Scanner scanner;
    private RegisterHandler registerHandler;
    private LoginHandler loginHandler;
    private Controller controller;
    private Map commands;

    public MainView(ShopService shopService, Scanner scanner) {
        this.scanner = scanner;
        loginHandler = new LoginHandler(shopService, scanner);
        registerHandler = new RegisterHandler(scanner);
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands() {
        commands = new HashMap();
        commands.put("1", loginHandler);
        commands.put("2", registerHandler);
    }

    public void run(){
        showMainMenu();
        String userInput = "";
        do {
            userInput = scanner.nextLine();

            if(!userInput.equals("0")){
                controller.handleUserInput(userInput);
                showMainMenu();
            }
        } while(!userInput.equals("0"));
        System.exit(0);
    }

    private void showMainMenu() {
        System.out.println("Welcome to Jogurtowska Shop");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("0 - exit");
    }
}
