package com.presentation.pages;

import com.presentation.annotations.PageName;
import com.presentation.annotations.XpathLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
@PageName("Google Search")
public class GoogleSearchPage extends BasePage {

    @XpathLabel("Search Button")
    private String searchButtonXpath = "//*[@name='btnK']";

    @XpathLabel("Search Field")
    private String searchFieldXpath = "(//*[@name='q'])";

    @XpathLabel("The First Result")
    private String theFirstResultXpath = "(//div[@id='search']//a)[1]";

    public GoogleSearchPage(WebDriver driver){
        super(driver);
        setVerifyXpath(searchButtonXpath);
    }

    @Override
    public boolean verify(){
        return $(this.getVerifyXpath()).isPresent();
    }

}
