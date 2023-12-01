package tests.day08_actions_faker_filetestleri;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c02_ActionsAşağıyaİnme extends TestBase {

    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    // play butonu iframe icinde oldugundan, once iframe'e gecis yapalim
    //5- videoyu calistirdiginizi test edin


    @Test
    public void iframeTesti(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(5);

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        ReusableMethods.bekle(1);
      driver.findElement(By.xpath("//button[@title='Oynat']")).click();

        //5- videoyu calistirdiginizi test edin
        WebElement kontrolElementi = driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(kontrolElementi.isDisplayed());

        ReusableMethods.bekle(5);




    }
}
