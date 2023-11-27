package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c03_Actions extends TestBase {

    // contextclick sağ click demek

    @Test
    public void sağClickTesti(){
        //  1- https://testotomasyonu.com/click sitesine gidin
        //  2- “DGI Drones” uzerinde sag click yapin
        // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        // 4- Tamam diyerek alert’i kapatalim

        //  1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);

        //  2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement DgıDroneYazısı= driver.findElement(By.id("hot-spot"));
        actions.contextClick(DgıDroneYazısı).perform();

        // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertYazıElementi="Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazıElementi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazıElementi,actualAlertYazıElementi);

        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();




    }
}
