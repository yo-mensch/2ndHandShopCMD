package view.home.handlers;

import service.UserService;
import view.handler.Handler;
import view.home.shopping.ShoppingView;

import java.util.Scanner;

public class ShoppingHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public ShoppingHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        ShoppingView shoppingView = new ShoppingView(userService,scanner);
        shoppingView.run();
    }
}
