package service;

import model.Address;
import model.Product;
import model.User;

public class UserService {
    private User user;
    private ShopService shopService;

    public UserService(User user, ShopService shopService) {
        this.user = user;
        this.shopService = shopService;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void addProductForSale(Product product){
        user.getProductsForSale().add(product);
        shopService.addProductToShop(product);
    }

    public void updateUserAddress(Address address){
        user.setAddress(address);
    }
}
