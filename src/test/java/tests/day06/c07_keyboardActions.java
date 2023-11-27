package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c07_keyboardActions extends TestBase {


    @Test
    public void test01(){
        // 2- https://www.testotomasyonu.com sayfasina gidelim
        // 3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        // 4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        // 2- https://www.testotomasyonu.com sayfasina gidelim
        driver.get(" https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // 3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu= driver.findElement(By.xpath("(//*[@id='global-search'])[1]"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("ı")
                .keyUp(Keys.SHIFT)
                .sendKeys("3").perform();
        actions.sendKeys(Keys.ENTER).perform();

        // 4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
          WebElement ürünİsmi= driver.findElement(By.xpath("//*[@class='prod-title mb-3 '] "));
            String expectedÜrünİçeriği="DELL Core I3";
            String actualÜrünİsmi=ürünİsmi.getText();
        Assert.assertTrue(actualÜrünİsmi.contains(expectedÜrünİçeriği));

        ReusableMethods.bekle(2);
    }
}
