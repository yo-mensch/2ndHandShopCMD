package view.home.shopping.shopping_cart;

import model.Product;
import service.UserService;
import view.Controller;
import view.home.shopping.shopping_cart.handlers.CartUpdateHandler;
import view.home.shopping.shopping_cart.handlers.CheckoutHandler;
import view.printer.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCartView {
    private UserService userService;
    private Scanner scanner;
    private Controller controller;
    private Map commands;
    private CartUpdateHandler cartUpdateHandler;
    private CheckoutHandler checkoutHandler;

    public ShoppingCartView(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
        cartUpdateHandler = new CartUpdateHandler(userService,scanner);
        checkoutHandler = new CheckoutHandler(userService,scanner);
        addCommands();
        this.controller = new Controller(commands);
    }
    private void addCommands() {
        commands = new HashMap();
        commands.put("1", cartUpdateHandler);
        commands.put("2",checkoutHandler);
    }

    public void run(){

        printMenu();
        String userInput = "";
        do {
            userInput = scanner.nextLine();

            if(!userInput.equals("0")&&!userInput.equals("4")){
                controller.handleUserInput(userInput);
            }

            printMenu();
        } while(!userInput.equals("0"));
    }

    public void printMenu(){
        Printer.printSeparation();
        Printer.printMessage("1 - Remove product(-s) from cart");
        Printer.printMessage("2 - Checkout");
        Printer.printMessage("0 - Exit this menu");
    }
}
