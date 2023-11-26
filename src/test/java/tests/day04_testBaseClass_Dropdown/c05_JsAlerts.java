package tests.day04_testBaseClass_Dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c05_JsAlerts extends TestBase {
    //3 test method'u olusturup asagidaki gorevi tamamlayin
    //1. Test
    //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
    //  driver.get("https://testotomasyonu.com/javascriptAlert");
    //	- 1.alert'e tiklayin
    //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    //	-  OK tusuna basip alert'i kapatin
    //2.Test
    //	- https://testotomasyonu.com/javascriptAlert adresine gidin
    //	- 2.alert'e tiklayalim jsConfirm()
    //	- Cancel'a basip,
    //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    //3.Test
    //	- https://testotomasyonu.com/javascriptAlert adresine gidin
    //	- 3.alert'e tiklayalim
    //	- Cikan prompt ekranina "Abdullah" yazdiralim
    //	- OK tusuna basarak alert'i kapatalim
    //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim


    @Test
    public void jsBasicAlert() {
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazısı = "I am a JS Alert";
        String actualAlertYazısı = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazısı, actualAlertYazısı);
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmAlert() {
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get(" https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim jsConfirm()
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        //	- Cancel'a basip,
        ReusableMethods.bekle(2);
        driver.switchTo().alert().dismiss();
        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement resultYazıElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResultYazısı = "You clicked: Cancel";
        String actualResultYazısı = resultYazıElementi.getText();
        Assert.assertEquals(expectedResultYazısı, actualResultYazısı);


    }

    @Test
    public void jsPromptTesti() {
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement resultYazıElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResultYazısı = "Abdullah";
        String actualResultYazısı = resultYazıElementi.getText();
        Assert.assertTrue(actualResultYazısı.contains(expectedResultYazısı));

    }
}