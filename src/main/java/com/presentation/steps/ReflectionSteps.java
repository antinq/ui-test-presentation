package com.presentation.steps;

import com.presentation.annotations.PageName;
import com.presentation.annotations.XpathLabel;
import com.presentation.pages.BasePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ReflectionSteps {

    @Step
    public BasePage getPageByName(String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("com.presentation.pages");
        Set<Class<? extends BasePage>> pageClasses = reflections.getSubTypesOf(BasePage.class);
        for (Class<? extends BasePage> clazz : pageClasses){
            PageName clazzAnnotation = clazz.getAnnotation(PageName.class);
            if(clazzAnnotation != null && clazzAnnotation.value().equals(name)){
                Constructor pageConstructor = clazz.getConstructor(WebDriver.class);
                WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
                return (BasePage) pageConstructor.newInstance(driver);
            }
        }
        return null;
    }

    @Step
    public String getXpathAnnotated(BasePage page, String elementName) throws IllegalAccessException {
        for (Field field: page.getClass().getDeclaredFields()){
            XpathLabel label = field.getAnnotation(XpathLabel.class);
            if(label != null && label.value().equals(elementName)){
                field.setAccessible(true);
                return (String) field.get(page);
            }
        }
        return null;
    }

}
