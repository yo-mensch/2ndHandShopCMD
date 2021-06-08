package service;

import model.Shop;
import model.User;

public class ShopService {
    private Shop shop;

    public ShopService() {
        this.shop = Shop.getInstance();
    }

    public User addUserToShop(User user){
        shop.getUserList().add(user);
        return user;
    }

    public void login(String logInUsername, String logInPassword){
        //Shop shop = Shop.getInstance();
        for(User user: shop.getUserList()){
            if(logInUsername.equals(user.getUsername())&&logInPassword.equals(user.getPassword())){
                System.out.println("Succesfully logged in!");
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
        for(User user: shop.getUserList()){
            if(inputUsername.equals(user.getUsername())){
                System.out.println("Username already exists");
                return true;
            }
            if(inputEmail.equals(user.getEmail())){
                System.out.println("User with this email is already registered");
                return true;
            }
        }
        return false;
    }
}
