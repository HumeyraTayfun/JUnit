package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c02_Ödev extends TestBase {

    // icinde oldugumuz sayfa ve driver'i input olarak alip
    // ikinci sayfa Window Handle Degerini bize donduren
    // bir method kullanalim


    //● https://testotomasyonu.com/addremove/ adresine gidin.
    //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
    //● ’Please click for Electronics Products’ linkine tiklayin.
    //● Electronics sayfasinin acildigini test edin
    //● Bulunan urun sayisinin 16 olduğunu test edin
    //● Ilk actiginiz addremove sayfasina donun
      //● Url’in addremove icerdigini test edin

       @Test
      public void test01(){
             //● https://testotomasyonu.com/addremove/ adresine gidin.
             driver.get(" https://testotomasyonu.com/addremove/");
             String ilkSayfaWhd= driver.getWindowHandle();
               ReusableMethods.bekle(1);
             //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
             WebElement addRemoveElementsYazısı= driver.findElement(By.tagName("h2"));
            String expectedyazı="Add/Remove Elements";
            String actualYazı=addRemoveElementsYazısı.getText();
             Assert.assertEquals(expectedyazı,actualYazı);

            //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
              String expectedTitle= "Test Otomasyonu";
              String actualTitle=driver.getTitle();
              Assert.assertEquals(expectedTitle,actualTitle);

             //● ’Please click for Electronics Products’ linkine tiklayin.
                  ReusableMethods.bekle(1);
               driver.findElement(By.linkText("Electronics Products")).click();

             //● Electronics sayfasinin acildigini test edin
             String ikinciWhd = ReusableMethods.ilkSayfaWhdIleIkinciSayfaWhdBul(driver,ilkSayfaWhd);
             driver.switchTo().window(ikinciWhd);

             //● Bulunan urun sayisinin 16 olduğunu test edin
             WebElement sonuçYazıElementi=driver.findElement(By.xpath("//*[@class='product-count-text']"));
             String sonuçYazıElementiStr=sonuçYazıElementi.getText().replaceAll("\\D","" );
             int actualSonuçSayısı=Integer.parseInt(sonuçYazıElementiStr);
             int expectedSonuçYazı=16;
             Assert.assertEquals(expectedSonuçYazı,actualSonuçSayısı);

             //● Ilk actiginiz addremove sayfasina donun
             driver.switchTo().window(ilkSayfaWhd);

             //● Url’in addremove icerdigini test edin
             String expectedUrl="addremove";
             String actualUrl=driver.getCurrentUrl();
             Assert.assertTrue(actualUrl.contains(expectedUrl));

             ReusableMethods.bekle(2);














       }




      }
