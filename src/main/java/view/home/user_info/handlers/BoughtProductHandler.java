package view.home.user_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;

public class BoughtProductHandler implements Handler {
    private UserService userService;

    public BoughtProductHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        if(userService.getBoughtProducts()==null){
            System.out.println("You haven't bought any products!");
        } else {
            System.out.println("--------Products you bought--------");
            int index = 0;
            for(Product product : userService.getBoughtProducts()){
                index++;
                System.out.printf(index+". "+product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Description: " + product.getDescription());
                System.out.println("----------------");
            }
        }
    }
}
