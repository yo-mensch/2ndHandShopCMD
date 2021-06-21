package view.home.user_info.handlers;

import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class EmailHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public EmailHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("Enter new email: ");
        String newEmail = scanner.nextLine();
        userService.updateEmail(newEmail);
    }
}
