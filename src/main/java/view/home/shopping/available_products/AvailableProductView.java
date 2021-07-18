package view.home.shopping.available_products;

import model.Product;
import service.UserService;

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
            System.out.println("--------------");
            System.out.println("Shop is empty!");
            System.out.println("--------------");
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
        int index = 0;
        System.out.println("----------------");
        for(Product product : userService.getAvailableProducts()){
            index++;
            System.out.println(index + ". " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("----------------");
        }
    }

    private void handleInput() {
        System.out.println("Enter a product name to add it to your cart!");
        System.out.println("0 - exit");
        String userInput = "";
        do {
            userInput = scanner.nextLine();
            if(!userInput.equals("0")) {
                Product foundProduct = userService.findProductByName(userInput);
                if (foundProduct == null) {
                    System.out.println("Product with this name does not exist!");
                } else {
                    userService.addProductToCart(foundProduct);
                    System.out.println("Product added to your Cart!");
                    System.out.println("----------------------");
                    userInput = "";
                }
            }
        } while(!userInput.equals("0"));
    }

}
