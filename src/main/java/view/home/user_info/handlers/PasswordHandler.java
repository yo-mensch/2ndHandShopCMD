package view.home.user_info.handlers;

import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

import java.util.Scanner;

public class PasswordHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public PasswordHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        boolean doPasswordsMatch = false;
        while (!doPasswordsMatch) {
            Printer.printMessage("Enter your new password: ");
            String newPassword = scanner.nextLine();
            Printer.printMessage("Confirm your new password: ");
            String confirmedPassword = scanner.nextLine();
            if (newPassword.equals(confirmedPassword)) {
                doPasswordsMatch = true;
                userService.updatePassword(newPassword);
            } else {
                Printer.printMessage("Passwords do not match");
            }
        }
    }


}
