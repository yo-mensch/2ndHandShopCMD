package view.home.handlers;

import service.UserService;
import view.handler.Handler;
import view.home.product_info.ProductInfoView;

import java.util.Scanner;

public class ProductHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public ProductHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        ProductInfoView productInfoView = new ProductInfoView(scanner,userService);
        productInfoView.run();
    }
}
