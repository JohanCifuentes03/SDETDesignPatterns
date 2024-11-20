package co.com.sofka.test.command;

import co.com.sofka.command.page.HomePage;
import co.com.sofka.command.validator.ElementValidator;
import co.com.sofka.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ElementValidator::validate)
                .forEach(Assert::assertTrue);
    }
}
