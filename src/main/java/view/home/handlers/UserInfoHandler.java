package view.home.handlers;

import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class UserInfoHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public UserInfoHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("You entered user info handler");
        System.out.println("1 - Enter new email and password");
        System.out.println("2 - Enter your address");
    }
}
