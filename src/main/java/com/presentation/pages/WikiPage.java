package com.presentation.pages;

import com.presentation.annotations.PageName;
import com.presentation.annotations.XpathLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@PageName("Wiki")
@Getter
public class WikiPage extends BasePage{

    @XpathLabel("Wikipedia Banner")
    private String wikiMainBannerXpath = "//div[@role='banner']/a";

    @XpathLabel("First Header")
    private String theFirstHeaderXpath = "//*[@id='firstHeading']/span[1]";

    @XpathLabel("First Headline")
    private String theFirstHeadlineXpath = "//*[contains(@*,'mw-heading mw-heading1')]";

    public WikiPage(WebDriver driver){
        super(driver);
        setVerifyXpath(wikiMainBannerXpath);
    }

}
