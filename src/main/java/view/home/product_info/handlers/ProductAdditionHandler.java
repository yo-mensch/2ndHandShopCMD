package view.home.product_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class ProductAdditionHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public ProductAdditionHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("Enter a product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter a product price: ");
        float productPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter a product description: ");
        String productDescription = scanner.nextLine();
        if(doProductsMatch(productName)){
            System.out.println("Product with this name already exists");
        } else {
            Product product = new Product(productName, productDescription, productPrice, userService.getLoggedInUser());
            userService.addProductForSale(product);
        }
    }

    private boolean doProductsMatch(String productName){
        if(userService.findProductForSaleByName(productName)==null){
            return false;
        }
        return true;
    }
}
