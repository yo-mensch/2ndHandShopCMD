package view.home.shopping.shopping_cart.handlers;

import service.UserService;
import view.handler.Handler;
import view.home.user_info.handlers.AddressHandler;
import view.printer.Printer;

import java.util.Scanner;

public class CheckoutHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public CheckoutHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if(!userService.isCartEmpty()){
            if(enoughMoney()){
                if (!hasAddress()) {
                    Printer.printMessage("You have not provided your address!");
                    AddressHandler addressHandler = new AddressHandler(userService, scanner);
                    addressHandler.execute();
                }
                checkout();
            } else {
                Printer.printMessage("You don't have enough money in your balance!");
            }
        } else {
            Printer.printMessage("You cannot checkout with an empty cart!");
        }
    }

    private boolean enoughMoney(){
        return userService.getShoppingCart().getTotalPrice() < userService.getLoggedInUser().getBalance();
    }

    private boolean hasAddress(){
        return userService.getLoggedInUser().getAddress() != null;
    }

    private void checkout(){
        userService.buyProducts();
        Printer.printMessage("Success!");
    }
}
