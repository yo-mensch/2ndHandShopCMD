package view.home.shopping.shopping_cart.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

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
            Printer.printSeparation();
            Printer.printMessage("Your cart is empty!");
        } else {
            printWarning();
            String productName = "";
            Printer.printMessage("Enter product name: ");
            productName = scanner.nextLine();
            Product foundProduct = userService.findProductByName(productName);
            if(foundProduct!=null){
                userService.removeProductFromCart(foundProduct);
                Printer.printMessage("Success!");
            }
        }
    }

    public void printWarning(){
        Printer.printWarning();
    }
}
