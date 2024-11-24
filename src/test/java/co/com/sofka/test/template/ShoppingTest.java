package co.com.sofka.test.template;

import co.com.sofka.template.ShoppingTemplate;
import co.com.sofka.template.amazon.AmazonShopping;
import co.com.sofka.template.ebay.EbayShopping;
import co.com.sofka.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {


    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate,
                             String product) {
        shoppingTemplate.shop(product);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {new AmazonShopping(driver), "Iphone 15 Pro Max"},
                {new EbayShopping(driver), "Xbox Series S"}
        };
    }


}
