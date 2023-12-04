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

public class c01_ExpilitlyWait {
    //1. Bir class olusturun : WaitTest
//   2. Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.
    //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
   //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        WebElement itsGoneYazıElementi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneYazıElementi.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        WebElement itsabackElementi= driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsabackElementi.isDisplayed());
        driver.quit();


    }


    @Test
    public void explicitWaitTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls ");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement itsGoneYazıElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
       WebElement itsBackYazıElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));


         driver.quit();
         /*
            Eger kullanmak istedigimiz element locate edilebilir durumda ise
            once locate edip
            sonra istenen condition icin bekleyebiliriz
            Ama bu soruda oldugu gibi
            locate ve bekleme kisir dongu olusturuyorsa
            locate ve bekleme islemi birlikte yapilabilir

            // 1.adim : bir wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2.adim : bekleyecegimiz webelement'i locate edin
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
            // 3.adim : wait objesini kullanarak istediginiz webelement uzerinde islem yapin
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));

             */
    }




}