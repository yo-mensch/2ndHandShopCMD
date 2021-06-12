package service;

import model.Product;
import model.User;

public class UserService {
    private User user;

    public UserService(User user) { this.user = user; }

    public Product addProductForSale(Product product){
        user.getProductsForSale().add(product);
        return product;
    }
}
