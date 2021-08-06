package view.home.shopping.handlers;

import model.Product;
import model.ShoppingCart;
import service.UserService;
import view.handler.Handler;
import view.home.shopping.shopping_cart.ShoppingCartView;
import view.printer.Printer;

import java.util.Scanner;

public class ShoppingCartHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public ShoppingCartHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if(userService.isCartEmpty()){
            Printer.printMessage("Your cart is empty!");
            Printer.printMessage("Total price: 0.0$");
        } else {
            printCart();
            ShoppingCartView shoppingCartView = new ShoppingCartView(userService,scanner);
            shoppingCartView.run();
        }
    }

    private void printCart() {
        Printer.printMessage("-----Your Shopping Cart-----");
        Printer.printProductArray(userService.getShoppingCart().getProducts());
        System.out.printf("Total:   $"+userService.getShoppingCart().getTotalPrice());
    }
}
