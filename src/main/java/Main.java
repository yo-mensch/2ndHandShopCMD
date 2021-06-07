import model.Shop;
import service.ShopService;
import view.main.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop.getInstance().setVersion("v1");
        MainView mainView = new MainView(new ShopService(), new Scanner(System.in));
        mainView.run();
    }
}
