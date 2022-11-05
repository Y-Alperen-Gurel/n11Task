package com.n11.step_definitions;

import com.n11.pages.N11Anasayfa;
import com.n11.pages.N11GirişSayfa;
import com.n11.pages.N11KullanıcıSayfa;
import com.n11.utilities.BrowserUtils;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class N11_StepDef {

    N11Anasayfa n11Anasayfa= new N11Anasayfa();
    N11GirişSayfa n11GirişSayfa= new N11GirişSayfa();
    N11KullanıcıSayfa n11KullanıcıSayfa= new N11KullanıcıSayfa();

    String röle;
    int sayfa;
    String productId="";

    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();



    /**---------------------------------------------Anasayfa title kontrolü------------------------------------------*/

    @When("kullanici n11 ana sayfaya gider")
    public void kullanici_n11_ana_sayfaya_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("n11URL"));
    }
    @Then("Web page title {string} olmali")
    public void web_page_title_olmali(String string) {
        Assert.assertEquals(string,Driver.getDriver().getTitle());
    }


    /**---------------------------------------Anahtar kelimeye göre ürün listeleme------------------------------------*/
    @When("Gecerli kullanici bilgileri ile login olunur")
    public void gecerliKullaniciBilgileriIleLoginOlunur() throws InterruptedException {
        n11Anasayfa.girisyap.click();
        n11GirişSayfa.emailbox.sendKeys(ConfigurationReader.getProperty("email"));
        n11GirişSayfa.sifrebox.sendKeys(ConfigurationReader.getProperty("sifre"));
        n11GirişSayfa.girisBtn.click();
        Thread.sleep(5000);

    }

    @And("Arama alanina {string} yazılır")
    public void aramaAlaninaYazılır(String arg0) {
        röle=arg0;
        Driver.getDriver().navigate().refresh();
        n11KullanıcıSayfa.searchBox.sendKeys(arg0);
        n11KullanıcıSayfa.searchButton.click();
    }

    @Then("listelenen ürünlerin anahtar kelimeye uygun oldugu teyit edilir")
    public void listelenenÜrünlerinAnahtarKelimeyeUygunOlduguTeyitEdilir() {
        Assert.assertTrue(n11KullanıcıSayfa.ilkUrün.getText().contains(röle));
    }


    /**---------------------------------------Listeleme sayfaları arası gecis-----------------------------------------*/

    @When("kullanici {int}. sayfayi secer")
    public void kullaniciSayfayiSecer(int arg0) {
        sayfa=arg0;
        for (int i = 0; i < 28; i++) {
            BrowserUtils.sleep(3);// bekletmeden kod çalışmıyor nedeni ise sayfa daha tam yüklenmemiş oluyor.
            js.executeScript("window.scrollBy(0,600)");
        }

        n11KullanıcıSayfa.ikinciSayfaButonu.click();

    }


    @Then("Seçili sayfa ürünlerin listelendigi teyit edilir")
    public void seçiliSayfaÜrünlerinListelendigiTeyitEdilir() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(sayfa+""));//concatination
    }

    @When("üstten üçüncü ürün favoriye ekle")
    public void üsttenÜçüncüÜrünFavoriyeEkle() {
        n11KullanıcıSayfa.ücüncüUrün.click();
        productId=n11KullanıcıSayfa.ücüncüUrün.getAttribute("data-productid");
    }

    @And("favorilerim linkine tıkla")
    public void favorilerimLinkineTıkla() {
        n11KullanıcıSayfa.favoriBtn.click();
    }

    @And("Favorilerim'e tıkla")
    public void favorilerimETıkla() {
        n11KullanıcıSayfa.favListesi.click();
    }

    @Then("Favoriye eklenen ürün favori listesinde olmalı")
    public void favoriyeEklenenÜrünFavoriListesindeOlmalı() {

        Assert.assertEquals(productId,n11KullanıcıSayfa.favoriUrunu.getAttribute("data-id"));

    }

    @When("sil butonuna tıklayarak ürünü favoriden sil")
    public void silButonunaTıklayarakÜrünüFavoridenSil() {
        n11KullanıcıSayfa.favdenSilBtn.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
    }

    @Then("ürünün favorilerde olmamali")
    public void ürününFavorilerdeOlmamali() {
        Assert.assertTrue(n11KullanıcıSayfa.bosFavori.isDisplayed());
    }
}
