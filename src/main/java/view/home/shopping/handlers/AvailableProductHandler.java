package view.home.shopping.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;
import view.home.shopping.available_products.AvailableProductView;

import java.util.Scanner;

public class AvailableProductHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public AvailableProductHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        AvailableProductView availableProductView = new AvailableProductView(userService,scanner);
        availableProductView.run();
    }

}
