package tests.day10_excelOtomasyon_getScreenShot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class c03_tümSayfaScreenShot extends TestBase {
    @Test
    public void aramaTesti() throws IOException {

        // test otomasyonu anasayfaya gidin
        // Nutella icin arama yapin

        // Arama sonucunda urun bulunamadigini test edin
        // tum sayfanin fotografini cekip kaydedin
        // 1.adim tss objesi olustur
        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim
        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim



        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // Nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Arama sonucunda urun bulunamadigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String expectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);

        ReusableMethods.bekle(1);
        // tum sayfanin fotografini cekip kaydedin
        // 1.adim tss objesi olustur
        TakesScreenshot tss= (TakesScreenshot) driver;
        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim

        File tumSayfaScreenshot=new File("target/screenshots/tumSayfaScreenshot.jpg");
        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim
         File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(5);


    }
}
