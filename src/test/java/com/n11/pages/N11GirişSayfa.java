package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11GirişSayfa {
    public N11GirişSayfa(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement emailbox;

    @FindBy(id = "password")
    public WebElement sifrebox;

    @FindBy(id = "loginButton")
    public WebElement girisBtn;

    @FindBy(xpath = "//button[@class='dn-slide-deny-btn']")
    public WebElement popupDeny;

}
