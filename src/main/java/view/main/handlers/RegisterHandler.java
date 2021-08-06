package view.main.handlers;

import service.ShopService;
import view.handler.Handler;
import view.printer.Printer;

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
        Printer.printMessage("Enter username:");
        String usernameInput = scanner.nextLine();
        Printer.printMessage("Enter email");
        String emailInput = scanner.nextLine();
        Printer.printMessage("Enter password:");
        String passwordInput = scanner.nextLine();
        shopService.register(usernameInput,passwordInput,emailInput);
    }
}
