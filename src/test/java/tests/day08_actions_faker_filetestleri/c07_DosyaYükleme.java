package tests.day08_actions_faker_filetestleri;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c07_DosyaYükleme extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void dosyaYüklemeTesti(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home")+
                "\\Downloads\\ISTQB_AllChild (Kasım 2023).pdf";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement uplodedYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazıElementi="File Uploaded!";
        String actualYazıElementi=uplodedYaziElementi.getText();
        Assert.assertEquals(expectedYazıElementi,actualYazıElementi);

        ReusableMethods.bekle(10);






    }
}
