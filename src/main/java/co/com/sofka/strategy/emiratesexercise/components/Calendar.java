package co.com.sofka.strategy.emiratesexercise.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Calendar extends AbstractComponent {
    @FindBy(css = "eol-calendar div.ek-datepicker")
    private WebElement calendar;

    @FindBy(css = "div.label-month")
    private List<WebElement> months;

    @FindBy(css = ".ek-datepicker__button--next")
    private WebElement nextMonthBtn;

    public Calendar(WebDriver driver) {
        super(driver);
    }

    public void selectDate(String month, int day) {
        String dayXpath = String.format("//button[contains(normalize-space(@aria-label), '%d %s')]", day, month);
        boolean monthFound = false;

        while (!monthFound) {
            monthFound = months.stream().anyMatch(element -> element.getText().contains(month));

            if (monthFound) {
                try {
                    WebElement dayButton = driver.findElement(By.xpath(dayXpath));
                    dayButton.click();
                } catch (Exception e) {
                    throw new NotFoundException("El día especificado no está disponible en el mes visible: " + month);
                }
            } else {
                nextMonthBtn.click();
            }
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> calendar.isDisplayed());
    }
}
