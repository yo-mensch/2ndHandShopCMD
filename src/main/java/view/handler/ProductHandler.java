package view.handler;

public class ProductHandler implements Handler{
    public ProductHandler() {
    }

    @Override
    public void execute(){
        System.out.println("you entered product handler");
    }
}
