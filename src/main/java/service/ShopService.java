package service;

import model.Product;
import model.Shop;
import model.User;
import view.home.HomeView;
import view.home.handlers.ProductHandler;
import view.home.handlers.ShoppingHandler;
import view.home.handlers.UserInfoHandler;
import view.home.user_info.handlers.BoughtProductHandler;
import view.printer.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopService {
    private Shop shop;

    public ShopService() {
        this.shop = Shop.getInstance();
    }

    public void addUserToShop(User user) {
        shop.getUserList().add(user);
    }

    public void addProductToShop(Product product) {
        shop.getProductList().add(product);
    }

    public void deleteProductFromShop(Product product){
        shop.getProductList().remove(product);
    }

   public void login(String logInUsername, String logInPassword) {

        if (shop.getUserList().isEmpty()) {
            Printer.printMessage("Username or password not correct");
            return;
        }

        for (User user : shop.getUserList()) {
            if (userFound(logInUsername, logInPassword, user)) {
                Printer.printMessage("Successfully logged in!");
                renderHomeView(user);
                break;
            } else {
                Printer.printMessage("Username or password not correct");
                return;
            }
        }
        return;
    }

    private boolean userFound(String logInUsername, String logInPassword, User user) {
        return logInUsername.equals(user.getUsername()) && logInPassword.equals(user.getPassword());
    }

    private void renderHomeView(User user) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(user, this);
        UserInfoHandler userInfoHandler = new UserInfoHandler(userService, scanner);
        ProductHandler productHandler = new ProductHandler(userService,scanner);
        ShoppingHandler shoppingHandler = new ShoppingHandler(userService,scanner);
        BoughtProductHandler boughtProductHandler = new BoughtProductHandler(userService);

        HomeView homeView = new HomeView(userInfoHandler,productHandler,shoppingHandler,boughtProductHandler, scanner);
        homeView.run();
    }

    public void register(String inputUsername, String inputPassword, String inputEmail) {
        if (!isUserTaken(inputUsername, inputEmail)) {
            registerUser(inputUsername, inputPassword, inputEmail);
        }
    }

    private boolean isUserTaken(String inputUsername, String inputEmail) {
        if (findUserByEmail(inputEmail) != null) {
            Printer.printMessage("User with this email is already registered");
            return true;
        }
        if (findUserByUsername(inputUsername) != null) {
            Printer.printMessage("Username already exists");
            return true;
        }
        return false;
    }

    public User findUserByEmail(String email) {
        for (User user : shop.getUserList()) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    public User findUserByUsername(String username) {
        for (User user : shop.getUserList()) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    private void registerUser(String inputUsername, String inputPassword, String inputEmail) {
        User newUser = new User(inputUsername, inputPassword, inputEmail);
        addUserToShop(newUser);
    }

    public List<Product> getAvailableProducts(User user){
        List<Product> foundProducts = new ArrayList<>();
        for(Product product : shop.getProductList()){
            if(product.getAuthor() != user) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public Product findProductByName(String productName){
        for(Product product : shop.getProductList()){
            if(product.getName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public void deleteBoughtProducts(){
        for(Product product : shop.getProductList()){
            if(product.isBought()){
                User author = product.getAuthor();
                List<Product> authorsProducts = author.getProductsForSale();
                authorsProducts.remove(product);
                author.setProductsForSale(authorsProducts);
                deleteProductFromShop(product);
            }
        }
    }
}
