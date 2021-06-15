package view.home;

import view.handler.Handler;

public class ProductHandler implements Handler {
    public ProductHandler() {
    }

    @Override
    public void execute(){
        System.out.println("you entered product handler");
    }
}
