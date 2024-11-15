package co.com.sofka.strategy.emiratesexercise.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchFlight extends AbstractComponent {
    @FindBy(css = "input[name='Departure airport']")
    private WebElement departureAirport;

    @FindBy(xpath = "//label[text()='Departure airport']/ancestor::div[@class='js-origin-dropdown']//li")
    private List<WebElement> departureAirportOptions;

    @FindBy(css = "input[name='Arrival airport']")
    private WebElement arrivalAirport;

    @FindBy(xpath = "//label[text()='Arrival airport']/ancestor::div[@class='destination-dropdown']//li")
    private List<WebElement> arrivalAirportOptions;

    public SearchFlight(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> departureAirport.isDisplayed() && arrivalAirport.isDisplayed());
    }

    public void openDepartureAirportOptions() {
        actions.scrollToElement(this.departureAirport);
        this.departureAirport.click();
        wait.until(d -> departureAirportOptions.get(0).isDisplayed());
    }

    public void selectDepartureAirportByIndex(int index) {
        this.departureAirportOptions.get(index).click();
    }

    public void openArrivalAirportOptions() {
        this.arrivalAirport.click();
        wait.until(d -> arrivalAirportOptions.get(0).isDisplayed());
    }

    public void selectArrivalAirportByIndex(int index) {
        this.arrivalAirportOptions.get(index).click();
    }
}
