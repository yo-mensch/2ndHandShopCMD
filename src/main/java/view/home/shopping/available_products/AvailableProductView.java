package view.home.shopping.available_products;

import model.Product;
import service.UserService;
import view.printer.Printer;

import java.util.Scanner;

public class AvailableProductView {
    private UserService userService;
    private Scanner scanner;

    public AvailableProductView(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void run(){
        if(isShopEmpty()){
            Printer.printSeparation();
            Printer.printMessage("Shop is empty!");
            Printer.printSeparation();
        } else {
            printAvailableProducts();
            handleInput();
        }
    }

    private boolean isShopEmpty(){
        if(userService.getAvailableProducts().size() == 0)
            return true;

        return false;
    }

    private void printAvailableProducts(){
        Printer.printProductArray(userService.getAvailableProducts());
    }

    private void handleInput() {
        Printer.printMessage("Enter a product name to add it to your cart!");
        Printer.printMessage("0 - exit");
        String userInput = "";
        do {
            userInput = scanner.nextLine();
            if(!userInput.equals("0")) {
                Product foundProduct = userService.findProductByName(userInput);
                if (foundProduct == null) {
                    Printer.printMessage("Product with this name does not exist!");
                } else {
                    userService.addProductToCart(foundProduct);
                    Printer.printMessage("Product added to your Cart!");
                    Printer.printSeparation();
                    userInput = "";
                }
            }
        } while(!userInput.equals("0"));
    }

}
