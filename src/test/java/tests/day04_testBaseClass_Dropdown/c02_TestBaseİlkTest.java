package tests.day04_testBaseClass_Dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class c02_TestBaseİlkTest extends TestBase{

    @Test
    public void aramaTesti(){
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonuçElementi= driver.findElement(By.className("product-count-text"));
        String aramaSonuçSayısıStr=aramaSonuçElementi.getText().replaceAll("\\D","");
        int aramaSonuçSayısı=Integer.parseInt(aramaSonuçSayısıStr);
        Assert.assertTrue(aramaSonuçSayısı>0);//passed
        ReusableMethods.bekle(2);
    }
}
