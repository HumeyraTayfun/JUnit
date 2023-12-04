package tests.Practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class p05 extends TestBase {

    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
// 2 ) Bir metod olusturun: iframeTest
//  3- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
//  4- Text Box'a "Merhaba Dunya!" yazin.
//  5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
//      ve  konsolda yazdirin.

            @Test
    public void iframeTesti(){
                // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
                driver.get("https://the-internet.herokuapp.com/iframe");
                // 2 ) Bir metod olusturun: iframeTest
                 //  3- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
                WebElement yaziElementi= driver.findElement(By.tagName("h3"));
                System.out.println(yaziElementi.getText());
              //  4- Text Box'a "Merhaba Dunya!" yazin.
                WebElement iframe= driver.findElement(By.tagName("iframe"));
                driver.switchTo().frame(iframe);
                WebElement textBoxKutusu= driver.findElement(By.tagName("p"));
                textBoxKutusu.clear();
                textBoxKutusu.sendKeys("Merhaba Dunya!");
                driver.switchTo().parentFrame();
           //  5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
                WebElement yaziLinki= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
                Assert.assertTrue(yaziLinki.isDisplayed());
                //ve  konsolda yazdirin.
                System.out.println(yaziLinki.getText());



            }
}
