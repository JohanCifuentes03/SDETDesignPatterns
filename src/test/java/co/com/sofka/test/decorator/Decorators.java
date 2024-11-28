package co.com.sofka.test.decorator;

import co.com.sofka.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {
    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(e -> Assert.assertTrue(e.isDisplayed()));
    }

    private static void shouldNotBeDisplayed(List<WebElement> elements) {
        elements.forEach(e -> Assert.assertFalse(e.isDisplayed()));
    }

    // Ingredients
    private static final Consumer<DashboardPage> adminComponentPresent = (
            d -> shouldDisplay(d.getAdminComponents()));

    private static final Consumer<DashboardPage> adminComponentNoPresent = (
            d -> shouldNotBeDisplayed(d.getAdminComponents()));

    private static final Consumer<DashboardPage> superComponentPresent = (
            d -> shouldDisplay(d.getSuperUserComponents()));

    private static final Consumer<DashboardPage> superComponentNotPresent = (
            d -> shouldNotBeDisplayed(d.getSuperUserComponents()));

    private static final Consumer<DashboardPage> guestComponentPresent = (
            d -> shouldDisplay(d.getGuestsComponents()));

    // role selection
    private static final Consumer<DashboardPage> adminSelection =
            d -> d.selectRole("admin");

    private static final Consumer<DashboardPage> suSelection =
            d -> d.selectRole("superuser");

    private static final Consumer<DashboardPage> guestSelection =
            d -> d.selectRole("guest");

    // user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection
            .andThen(guestComponentPresent)
            .andThen(superComponentNotPresent)
            .andThen(adminComponentNoPresent);

    public static final Consumer<DashboardPage> suPage = suSelection
            .andThen(superComponentPresent)
            .andThen(guestComponentPresent)
            .andThen(adminComponentNoPresent);

    public static final Consumer<DashboardPage> adminPage = adminSelection
            .andThen(adminComponentPresent)
            .andThen(guestComponentPresent)
            .andThen(superComponentPresent);
}
