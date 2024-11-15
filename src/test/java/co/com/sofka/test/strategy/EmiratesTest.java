package co.com.sofka.test.strategy;

import co.com.sofka.strategy.emiratesexercise.pages.EmiratesPage;
import co.com.sofka.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmiratesTest extends BaseTest {
    private EmiratesPage emiratesPage;

    @BeforeTest
    public void setEmiratesPage(){
        this.emiratesPage = new EmiratesPage(driver);
    }

    @Test
    public void reserveFly(){
        emiratesPage.goTo();
        emiratesPage.getCookies().acceptCookies();
        emiratesPage.getSearchFlight().openDepartureAirportOptions();
        emiratesPage.getSearchFlight().selectDepartureAirportByIndex(1);
        emiratesPage.getSearchFlight().openArrivalAirportOptions();
        emiratesPage.getSearchFlight().selectArrivalAirportByIndex(0);
    }
}
