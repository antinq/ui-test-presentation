package com.presentation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

    private String verifyXpath;


    public BasePage(){
    }

    public BasePage (WebDriver driver){
        super(driver);
    }

    public String getVerifyXpath(){
        return this.verifyXpath;
    }

    public void setVerifyXpath(String verifyXpath){
        this.verifyXpath = verifyXpath;
    }

    public boolean verify(){
        return $(verifyXpath).isDisplayed();
    }

}
