package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11KullanıcıSayfa {
    public N11KullanıcıSayfa(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchData")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@class='searchBtn']")
    public WebElement searchButton;

    @FindBy(xpath = "(//h3[@class='productName'])[1]")//Listede çıkan ilk ürünü kontrol eder
    public WebElement ilkUrün;

    @FindBy(xpath = "//a[@href='https://www.n11.com/arama?q=Samsung&pg=2']")
    public WebElement ikinciSayfaButonu;

    @FindBy(xpath = "(//span[@title='Favorilere ekle'])[3]")
    public WebElement ücüncüUrün;

    @FindBy(xpath = "//a[@class='myFavorities ']")
    public WebElement favoriBtn;

    @FindBy(xpath = "//a[@href='https://www.n11.com/hesabim/favorilerim']")
    public WebElement favListesi;

    @FindBy(xpath = "//a[@class='plink']")
    public WebElement favoriUrunu;

    @FindBy(xpath = "//span[@class='deleteProFromFavorites']")
    public WebElement favdenSilBtn;

    @FindBy(xpath = "//div[@class='emptyWatchList hiddentext']")
    public WebElement bosFavori;
}
