package service;

import model.Address;
import model.Product;
import model.User;

import java.util.List;

public class  UserService {
    private User loggedInUser;
    private ShopService shopService;

    public UserService(User loggedInUser, ShopService shopService) {
        this.loggedInUser = loggedInUser;
        this.shopService = shopService;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public String getUsername() {
        return loggedInUser.getUsername();
    }

    public String getEmail() {
        return loggedInUser.getEmail();
    }

    public List<Product> getProductsForSale(){
        return loggedInUser.getProductsForSale();
    }

    public void addProductForSale(Product product) {
        loggedInUser.getProductsForSale().add(product);
        shopService.addProductToShop(product);
    }

    public Product findProductForSaleByName(String name) {
        for (Product product : loggedInUser.getProductsForSale()) {
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public void deleteProductForSale(String productName){
        List<Product> productList = loggedInUser.getProductsForSale();
        for(Product product : productList){
            if(productName.equals(product.getName())){
                productList.remove(product);
                loggedInUser.setProductsForSale(productList);
                shopService.deleteProductFromShop(product);
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void updateUserAddress(Address address) {
        loggedInUser.setAddress(address);
    }

    public void updatePassword(String password) {
        loggedInUser.setPassword(password);
    }

    public void updateEmail(String email) {
        loggedInUser.setEmail(email);
    }
}
