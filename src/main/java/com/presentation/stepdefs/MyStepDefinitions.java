package com.presentation.stepdefs;

import com.presentation.pages.BasePage;
import com.presentation.steps.BaseSteps;
import com.presentation.steps.ReflectionSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;

public class MyStepDefinitions {

    @Steps
    private BaseSteps baseSteps;

    @Steps
    private ReflectionSteps reflectionSteps;


    @Given("The user opens {string} link")
    public void theUserOpensLink(String link) {
        baseSteps.openLinkInBrowser(link);
    }

    @Then("The user verifies that the page {string} is opened")
    public void theUserVerifiesThatThePageIsOpened(String pageName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BasePage page = reflectionSteps.getPageByName(pageName);
        Assert.assertTrue("The page" + pageName + " is not opened", page.verify());
    }

    @When("The user types the text {string} into the field {string} on the {string} page")
    public void theUserTypesTheTextIntoTheFieldOnThePage(String text, String fieldName, String pageName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page, fieldName);
        baseSteps.typeTextIntoField(page, locator, text);
    }

    @When("The user clicks the button {string} on {string} page")
    public void theUserClicksTheButtonOnPage(String buttonName, String pageName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page, buttonName);
        baseSteps.clickButton(page, locator);
    }

    @Then("The user verifies that the element {string} value on the page {string} is equal to {string}")
    public void theUserVerifiesThatTheElementValueOnThePageIsEqualTo(String elementName, String pageName, String expectedValue) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page, elementName);
        String actualValue = baseSteps.getElementText(page, locator);
        Assertions.assertThat(baseSteps.getElementText(page, locator))
                        .isEqualTo(expectedValue);
    }

}
