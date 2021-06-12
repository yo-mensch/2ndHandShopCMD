package service;

import model.Product;
import model.Shop;
import model.User;
import view.home.HomeView;

import java.util.Scanner;

public class ShopService {
    private Shop shop;

    public ShopService() {
        this.shop = Shop.getInstance();
    }

    public User addUserToShop(User user){
        shop.getUserList().add(user);
        return user;
    }

    public Product addProductToShop(Product product){
        shop.getProductList().add(product);
        return product;
    }

    public User findUserByEmail(String email){
        for(User user: shop.getUserList()){
            if(email.equals(user.getEmail())){
                return user;
            }
        }
        return null;
    }

    public User findUserByUsername(String username){
        for(User user: shop.getUserList()){
            if(username.equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }

    public void login(String logInUsername, String logInPassword){
        for(User user: shop.getUserList()){
            if(logInUsername.equals(user.getUsername())&&logInPassword.equals(user.getPassword())){
                System.out.println("Succesfully logged in!");
                HomeView homeView = new HomeView(new ShopService(), new Scanner(System.in));
                homeView.run(user);
            } else {
                System.out.println("Username or password not correcto");
            }
        }
    }

    public void register(String inputUsername, String inputPassword, String inputEmail){
        boolean foundUser = isUserTaken(inputUsername, inputEmail);
        if(!foundUser) {
            User newUser = new User(inputUsername, inputPassword, inputEmail);
            addUserToShop(newUser);
        }
    }

    private boolean isUserTaken(String inputUsername, String inputEmail) {
        if(findUserByEmail(inputEmail)!=null){
            System.out.println("User with this email is already registered");
            return true;
        }
        if(findUserByUsername(inputUsername)!=null){
            System.out.println("Username already exists");
            return true;
        }
        return false;
    }
}
