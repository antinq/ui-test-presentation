package com.presentation.steps;

import com.presentation.pages.BasePage;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeDisabledException;
import org.fluentlenium.core.wait.FluentWait;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class BaseSteps {

    @Step
    public void openLinkInBrowser(String link) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver.get(link);
    }

    public void typeTextIntoField(BasePage page, String locator, String text) {
        page.$$(locator).stream()
                .filter(e -> e.waitUntilDisabled().isDisplayed())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not visible"))
                .type(text);
    }

    public void clickButton(BasePage page, String locator) {
        page.$$(locator).stream()
                .filter(e -> e.isVisible() && e.isClickable())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not clickable or visible"))
                .click();
    }

    public String getElementText(BasePage page, String locator) {
        return page.$(locator).getText();
    }

    }
