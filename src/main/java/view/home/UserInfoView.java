package view.home;

import service.UserService;
import view.Controller;
import view.home.handlers.EmailHandler;
import view.home.handlers.PasswordHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInfoView {
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private UserService userService;
    private PasswordHandler passwordHandler;
    private EmailHandler emailHandler;

    public UserInfoView(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
        passwordHandler = new PasswordHandler(this.userService,scanner);
        emailHandler = new EmailHandler(this.userService,scanner);
        addCommands();
        this.controller = new Controller(commands);
    }

    private void addCommands(){
        commands = new HashMap();
        commands.put("1",passwordHandler);
        commands.put("2", emailHandler);
        //commands.put("3", shoppingHandler);
    }

    private void printMenu(){
        System.out.println("1 - Update password");
        System.out.println("2 - Update email");
        System.out.println("3 - Update address");
        System.out.println("0 - Exit this menu");
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
