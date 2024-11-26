package co.com.sofka.test.executearound;

import co.com.sofka.executeAround.MainPage;
import co.com.sofka.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setLastName("ln1");
            a.setAddress("Calle A SUR A");
            a.setText("I'm filling text for frame A");
        });
        this.mainPage.onFrameB(b -> {
            b.setFirstName("fn2");
            b.setLastName("ln2");
            b.setAddress("Calle B SUR B");
            b.setText("I'm filling text for frame B");
        });

        this.mainPage.onFrameC(c -> {
            c.setFirstName("fn3");
            c.setLastName("ln3");
            c.setAddress("Calle C SUR C");
            c.setText("I'm filling text for frame C");
        });
    }
}
