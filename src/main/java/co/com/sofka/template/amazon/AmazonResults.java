package co.com.sofka.template.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonResults {
    @FindBy(css = "a span.a-size-medium")
    protected List<WebElement> results;

    public void selectResult(int index) {
        results.get(index).click();
    }
}
