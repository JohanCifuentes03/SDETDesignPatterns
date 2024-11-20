package co.com.sofka.test.strategy;

import co.com.sofka.strategy.emiratesexercise.pages.EmiratesPage;
import co.com.sofka.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmiratesTest extends BaseTest {
    private EmiratesPage emiratesPage;

    @BeforeTest
    public void setEmiratesPage() {
        this.emiratesPage = new EmiratesPage(driver);
    }

    @Test
    public void reserveFly() {
        submitBasicData();
    }

    public void submitBasicData() {
        emiratesPage.goTo();
        emiratesPage.acceptCookies();
        emiratesPage.searchDepartureAirportByIndex(0);
        emiratesPage.searchArrivalAirportByIndex(1);
        emiratesPage.searchDate("November", 20);
        emiratesPage.searchDate("March", 15);
        emiratesPage.submit();
    }
}
