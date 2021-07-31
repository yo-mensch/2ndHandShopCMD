package view.home.shopping.handlers;

import model.Product;
import model.ShoppingCart;
import service.UserService;
import view.handler.Handler;
import view.home.shopping.shopping_cart.ShoppingCartView;

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
            System.out.println("Your cart is empty!");
            System.out.println("Total price: 0.0$");
        } else {
            printCart();
            ShoppingCartView shoppingCartView = new ShoppingCartView(userService,scanner);
            shoppingCartView.run();
        }
    }

    private void printCart() {
        System.out.println("-----Your Shopping Cart-----");
        int index = 0;
        for(Product product : userService.getShoppingCart().getProducts()){
            index++;
            System.out.println(index + ". " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("----------------");
        }
        System.out.printf("Total:   $"+userService.getShoppingCart().getTotalPrice());
    }
}
