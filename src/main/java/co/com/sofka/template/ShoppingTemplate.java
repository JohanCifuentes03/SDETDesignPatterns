package co.com.sofka.template;

public abstract class ShoppingTemplate {
    public abstract void launchSite();

    public abstract void searchProduct(String product);

    public abstract void selectProduct();

    public abstract void buy();

    public void shop(String product) {
        launchSite();
        searchProduct(product);
        selectProduct();
        buy();
    }
}
