package service;

import model.Product;
import model.Shop;
import model.User;
import view.home.HomeView;
import view.home.handlers.ProductHandler;
import view.home.handlers.UserInfoHandler;

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
            System.out.println("Username or password not correct");
            return;
        }

        for (User user : shop.getUserList()) {
            if (userFound(logInUsername, logInPassword, user)) {
                System.out.println("Successfully logged in!");
                renderHomeView(user);
            } else {
                System.out.println("Username or password not correcto");
            }
        }
    }

    private boolean userFound(String logInUsername, String logInPassword, User user) {
        return logInUsername.equals(user.getUsername()) && logInPassword.equals(user.getPassword());
    }

    private void renderHomeView(User user) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(user, this);
        UserInfoHandler userInfoHandler = new UserInfoHandler(userService, scanner);
        ProductHandler productHandler = new ProductHandler(userService,scanner);

        HomeView homeView = new HomeView(userInfoHandler,productHandler, scanner);
        homeView.run();
    }

    public void register(String inputUsername, String inputPassword, String inputEmail) {
        if (!isUserTaken(inputUsername, inputEmail)) {
            registerUser(inputUsername, inputPassword, inputEmail);
        }
    }

    private boolean isUserTaken(String inputUsername, String inputEmail) {
        if (findUserByEmail(inputEmail) != null) {
            System.out.println("User with this email is already registered");
            return true;
        }
        if (findUserByUsername(inputUsername) != null) {
            System.out.println("Username already exists");
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

}
