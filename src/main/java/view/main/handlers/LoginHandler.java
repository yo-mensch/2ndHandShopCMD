package view.main.handlers;

import service.ShopService;
import view.handler.Handler;
import view.printer.Printer;

import java.util.Scanner;

public class LoginHandler implements Handler {
    private ShopService shopService;
    private Scanner scanner;

    public LoginHandler(ShopService shopService, Scanner scanner) {
        this.shopService = shopService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        Printer.printMessage("Enter username: ");
        String logInUsername = scanner.nextLine();
        Printer.printMessage("Enter password: ");
        String logInPassword = scanner.nextLine();
        shopService.login(logInUsername, logInPassword);
    }
}
