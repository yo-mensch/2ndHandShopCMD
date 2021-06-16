package service;

import model.Address;
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

    public void addUserToShop(User user){
        shop.getUserList().add(user);
    }

    public void addProductToShop(Product product){
        shop.getProductList().add(product);
    }

    public void updateUserEmail(String username, String email){
        User foundUser = findUserByUsername(username);
        foundUser.setEmail(email);
    }

    public void updateUserPassword(String username, String password){
        User foundUser = findUserByUsername(username);
        foundUser.setPassword(password);
    }

    public void updateUserAddress(String username, Address address){
        User foundUser = findUserByUsername(username);
        foundUser.setAddress(address);
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
                System.out.println("Successfully logged in!");
                HomeView homeView = new HomeView(new UserService(user,this), new Scanner(System.in));
                homeView.run();
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
