package view.home.shopping.handlers;

import model.Product;
import model.ShoppingCart;
import service.UserService;
import view.handler.Handler;

public class ShoppingCartHandler implements Handler {
    private UserService userService;

    public ShoppingCartHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        if(isCartEmpty()){
            System.out.println("Your cart is empty!");
            System.out.println("Total price: 0.0$");
        } else {
            //TODO: new view & handler for cart CRUD operations & checkout
        }
    }

    public boolean isCartEmpty(){
        for(Product product : getCart().getProducts()){
            return false;
        }
        return true;
    }

    public ShoppingCart getCart(){
        return userService.getShoppingCart();
    }
}
