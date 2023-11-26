package tests.day03_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c05_CheckBox {
    //	a. Verilen web sayfasına gidin.
    //	     https://testotomasyonu.com/form
    //	b. Sirt Agrisi ve Carpinti checkbox’larini secin

    //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
    //  	olduğunu test edin
    //	d. Seker ve Epilepsi checkbox’larininin seçili
    //  	olmadigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sırtAğrısı= driver.findElement(By.id("gridCheck5"));
        sırtAğrısı.click();
        WebElement çarpıntı= driver.findElement(By.id("gridCheck4"));
        çarpıntı.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
        //  	olduğunu test edin

        Assert.assertTrue(sırtAğrısı.isSelected());
        Assert.assertTrue(çarpıntı.isSelected());
        çarpıntı.sendKeys(Keys.PAGE_DOWN);//sayfayı aşagı indirmeye yarar

        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //  	olmadigini test edin
        WebElement şeker= driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsi= driver.findElement(By.id("hastalikCheck7"));
        Assert.assertFalse(şeker.isSelected());
        Assert.assertFalse(epilepsi.isSelected());
    }
}
