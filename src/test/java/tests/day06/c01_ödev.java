package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c01_ödev extends TestBase {

      /*
        Kontrolsuz bir tab/window acildiginda
        eger yeni acilan tab/window'un title degeri biliniyorsa
        driver'i acilan sayfaya geciren bir method olusturun

        input : driver , Test Otomasyonu - Electronics

     */

    @Test
    public void test01() {
        //● https://testotomasyonu.com/addremove/ adresine gidin.

        //   ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        //  ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        //  ● ‘Please click for Electronics Products’ linkine tiklayin.
        // ● Electronics sayfasinin acildigini test edin
        // Bulunan urun sayisinin 16 olduğunu test edin
        //● Ilk actiginiz addremove sayfasina donun
        //        ● Url’in addremove icerdigini test edin

       driver.get ("https://testotomasyonu.com/addremove/");
        String ilkSayfaWhd= driver.getWindowHandle();
        WebElement yazıElementi= driver.findElement(By.tagName("h2"));
        String expectedTitle="Test Otomasyonu";
        String actualTitle= yazıElementi.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.findElement(By.linkText("Electronics Products")).click();
        driver = ReusableMethods.titleİleSayfaDeğiştir(driver,"Test Otomasyonu-Electronics");
        WebElement sonuçYazıElementi= driver.findElement(By.xpath("//*[@*=‘product-count-text’]"));
        String sonuçSayısıStr=sonuçYazıElementi.getText().replaceAll("\\D","");
        int actualSonuçSayısı=Integer.parseInt(sonuçSayısıStr);
        int expectedSonuçSayısı=16;
        Assert.assertEquals(expectedSonuçSayısı,actualSonuçSayısı);
        driver.switchTo().window(ilkSayfaWhd);
        String expectedUrlİçerik="addremove";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlİçerik));
        ReusableMethods.bekle(2);
    }
}

