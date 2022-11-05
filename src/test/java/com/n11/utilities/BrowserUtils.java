package com.n11.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedUrl, String expectedTitle){
        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            System.out.println(Driver.getDriver().getCurrentUrl());
            if(Driver.getDriver().getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

    public static void waitForInvisibiltyOf(WebElement webElement){//to prevent unexpected wait time we handle explicit and implicit use together
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void verifyURLContains(String expectedURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select=new Select(dropdownElement);
        List<WebElement> actualOptions=select.getOptions();
        List<String> result=new ArrayList<>();
        for (WebElement eachWebelement : actualOptions) {
            result.add(eachWebelement.getText());
        }
        return result;
    }


}
