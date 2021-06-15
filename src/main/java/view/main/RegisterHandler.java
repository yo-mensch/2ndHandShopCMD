package view.main;

import service.ShopService;
import view.handler.Handler;

import java.util.Scanner;

public class RegisterHandler implements Handler {
    private ShopService shopService;
    private Scanner scanner;

    public RegisterHandler(Scanner scanner) {
        this.shopService = new ShopService();
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter username:");
        String usernameInput = scanner.nextLine();
        System.out.println("Enter email");
        String emailInput = scanner.nextLine();
        System.out.println("Enter password:");
        String passwordInput = scanner.nextLine();
        shopService.register(usernameInput,passwordInput,emailInput);
    }
}
