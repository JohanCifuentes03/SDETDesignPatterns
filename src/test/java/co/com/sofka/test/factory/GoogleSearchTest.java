package co.com.sofka.test.factory;

import co.com.sofka.factory.GoogleFactory;
import co.com.sofka.factory.GooglePage;
import co.com.sofka.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword){
        GooglePage googlePage = GoogleFactory.get(language, driver);
        googlePage.launchSite();
        googlePage.search(keyword);
        int resultCount = googlePage.getResultsCount();

        Assert.assertTrue(resultCount > 1);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG","selenium"},
                {"FR","Design patterns"},
                {"SA","Docker"},
                {"ENG", "Cristiano Ronaldo"}
        };
    }
}
