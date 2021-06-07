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
        Shop shop = Shop.getInstance();
        for(User user: shop.getUserList()){
            if(logInUsername.equals(user.getUsername())&&logInPassword.equals(user.getPassword())){
                System.out.println("Succesfully logged in!");
            } else {
                System.out.println("Username or password not correcto");
            }
        }
    }
}
