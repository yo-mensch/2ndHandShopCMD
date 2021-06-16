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

    public String getEmail(){
        return user.getEmail();
    }

    public void addProductForSale(Product product){
        user.getProductsForSale().add(product);
        shopService.addProductToShop(product);
    }

    public Product findProductForSaleByName(String name){
        for(Product product: user.getProductsForSale()){
            if(name.equals(product.getName())){
                return product;
            }
        }
        return null;
    }

    public void updateUserAddress(Address address){
        user.setAddress(address);
        shopService.updateUserAddress(user.getUsername(),address);
    }

    public void updatePassword(String password){
        user.setPassword(password);
        shopService.updateUserPassword(user.getUsername(),password);
    }

    public void updateEmail(String email){
        user.setEmail(email);
        shopService.updateUserEmail(user.getUsername(),email);
    }
}
