package co.com.sofka.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInformation {
    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public void enterDetails(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }
}
