package view.handler;

import service.UserService;

import java.util.Scanner;

public class UserInfoHandler implements Handler{
    private UserService userService;
    private Scanner scanner;

    public UserInfoHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("You entered user info handler");
        System.out.println("Your username: " + userService.getUsername());
    }
}
