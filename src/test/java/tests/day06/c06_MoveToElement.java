package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c06_MoveToElement extends TestBase {

    @Test
    public void moveToElementTesti() {
        //1- https://www.testotomasyonu.com/ adresine gidin
        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        // 3- “Boys” linkine basin
        // 4- Acilan sayfadaki ilk urunu tiklayin
        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        ReusableMethods.bekle(1);
        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement kidsWearmenuElementi= driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        actions.moveToElement(kidsWearmenuElementi).perform();
        ReusableMethods.bekle(1);

        // 3- “Boys” linkine basin
        WebElement boysLinki = driver.findElement(By.linkText("Boys"));
        boysLinki.click();

        // 4- Acilan sayfadaki ilk urunu tiklayin
          driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]")).click();

        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
           WebElement ürünİsmi=driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));
           String expectedÜrünYazısı="Boys Shirt White Color";
           String actualÜrünYazısı=ürünİsmi.getText();
        Assert.assertEquals(expectedÜrünYazısı,actualÜrünYazısı);
        ReusableMethods.bekle(1);



    }
}