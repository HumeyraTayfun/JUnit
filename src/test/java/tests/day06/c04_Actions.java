package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c04_Actions extends TestBase {
      // contextclick sağ click demek
    @Test
    public void sağclickTesti() {

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        // 3- Cizili alan uzerinde sag click yapin
        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        //5- Tamam diyerek alert’i kapatalim
        //6- Elemental Selenium linkine tiklayalim
        // 7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethods.bekle(1);

        // 3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement çiziliAlan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(çiziliAlan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazısı="You selected a context menu";
        String actualAlertYazısı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazısı,actualAlertYazısı);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
           driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        // 7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        ReusableMethods.bekle(2);
        driver = ReusableMethods.titleİleSayfaDeğiştir(driver,"Elemental Selenium | Elemental Selenium");
        ReusableMethods.bekle(2);
        WebElement h1TagYaziElementi = driver.findElement(By.tagName("h1"));
          String expectedYazı="Make sure your code lands";
          String actualYazı=h1TagYaziElementi.getText();
          Assert.assertEquals(expectedYazı,actualYazı);





    }
}