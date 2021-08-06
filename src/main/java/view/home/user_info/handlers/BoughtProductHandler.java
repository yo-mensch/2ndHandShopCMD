package view.home.user_info.handlers;

import model.Product;
import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

public class BoughtProductHandler implements Handler {
    private UserService userService;

    public BoughtProductHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        if(userService.getBoughtProducts().isEmpty()){
            Printer.printMessage("You haven't bought any products!");
        } else {
            Printer.printMessage("--------Products you bought--------");
            Printer.printProductArray(userService.getBoughtProducts());
        }
    }
}
