package co.com.sofka.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quiteDriver(){
        this.driver.quit();
    }
}
