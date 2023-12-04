package tests.day07_wait_cookies_WebTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class c02_ExpilictWait {
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
      //      4. Textbox’in etkin olmadigini(enabled) dogrulayın
     //5. Enable butonuna tıklayın ve
    // 6.textbox etkin oluncaya kadar bekleyin
      //7.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
     //8. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void test01(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //      4. Textbox’in etkin olmadigini(enabled) dogrulayın

               WebElement textBoxKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxKutusu.isEnabled());
        //5. Enable butonuna tıklayın ve
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        // 6.textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxKutusu));
        //7.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYazısı= driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYazısı.isDisplayed());
        //8. Textbox’in etkin oldugunu(enabled) dogrulayın.
        textBoxKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBoxKutusu.isEnabled());
        driver.quit();

       //test passed

    }


}
