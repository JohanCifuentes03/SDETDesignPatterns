package co.com.sofka.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("–-disable-application-cache");

        this.driver = new ChromeDriver(options);
    }

    @AfterTest
    public void quiteDriver(){
        this.driver.quit();
    }
}
