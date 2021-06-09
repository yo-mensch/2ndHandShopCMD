package model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static Shop instance = new Shop();
    private String version;
    private List<User> userList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

    private Shop() {}

    public static Shop getInstance(){
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Product> getProductList() { return productList; }

    public void setProductList(List<Product> productList) { this.productList = productList; }
}
