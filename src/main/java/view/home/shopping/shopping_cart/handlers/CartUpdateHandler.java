package view.home.shopping.shopping_cart.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class CartUpdateHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public CartUpdateHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if(userService.isCartEmpty()){
            System.out.println("---------------");
            System.out.println("Your cart is empty!");
        } else {
            printWarning();
            String productName = "";
            System.out.println("Enter product name: ");
            productName = scanner.nextLine();
            Product foundProduct = userService.findProductByName(productName);
            if(foundProduct!=null){
                userService.removeProductFromCart(foundProduct);
                System.out.println("Success!");
            }
        }
    }

    public void printWarning(){
        System.out.println("------------WARNING------------");
        System.out.println("You're about to delete a product");
        System.out.println("This action cannot be undone.");
        System.out.println("-------------------------------");
    }
}
