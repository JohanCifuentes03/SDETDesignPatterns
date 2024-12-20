package co.com.sofka.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {
    private final WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(css = "div.guest")
    private List<WebElement> guestsComponents;

    @FindBy(css = "div.superuser")
    private List<WebElement> superUserComponents;

    @FindBy(css = "div.admin")
    private List<WebElement> adminComponents;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role) {
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getGuestsComponents() {
        return guestsComponents;
    }

    public List<WebElement> getSuperUserComponents() {
        return superUserComponents;
    }

    public List<WebElement> getAdminComponents() {
        return adminComponents;
    }
}
