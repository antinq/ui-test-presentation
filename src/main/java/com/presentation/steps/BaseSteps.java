package com.presentation.steps;

import com.presentation.pages.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    @Step
    public void openLinkInBrowser(String link) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver.get(link);
    }

    @Step
    public void typeTextIntoField(BasePage page, String locator, String text) {
        page.$$(locator).stream()
                .filter(e -> e.waitUntilEnabled().isDisplayed())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not visible"))
                .type(text);
    }

    @Step
    public void clickButton(BasePage page, String locator) {
        page.$$(locator).stream()
                .filter(e -> e.isVisible() && e.isClickable())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not clickable or visible"))
                .click();
    }

    @Step
    public String getElementText(BasePage page, String locator) {
        return page.$(locator).getText();
    }
}
