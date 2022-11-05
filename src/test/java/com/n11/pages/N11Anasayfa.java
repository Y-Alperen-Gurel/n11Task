package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11Anasayfa {

    public N11Anasayfa() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btnSignIn']")
    public WebElement girisyap;
}
