package view.handler;

import service.ShopService;

import java.util.Scanner;

public class LoginHandler implements Handler{
    private ShopService shopService;
    private Scanner scanner;

    public LoginHandler(ShopService shopService, Scanner scanner) {
        this.shopService = shopService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Login handler entered");
        System.out.println("Enter username: ");
        String logInUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String logInPassword = scanner.nextLine();
        shopService.login(logInUsername,logInPassword);
    }
}
