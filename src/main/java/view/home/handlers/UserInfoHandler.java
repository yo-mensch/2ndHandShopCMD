package view.home.handlers;

import service.UserService;
import view.handler.Handler;
import view.home.UserInfoView;

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
        UserInfoView userInfoView = new UserInfoView(scanner,userService);
        userInfoView.run();
    }
}
