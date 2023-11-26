package tests.day03_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c04_Assertions {

    // https://www.bestbuy.com/ adresine gidin
    // farklı test metotları oluşturarak aşağıdaki testleri yapın
    // 1.sayfa url inin  https://www.bestbuy.com/ a eşit olduğunu test edin
    //2. titleTest=> sayfa başlığının "Rest" içermediğini test edin
    //3. logoTest=> BestBuy logosunun görüntülendiğini test edin
    //4.FrancaisLinkTest=> Fransızca linkin görüntülendiğini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTesti(){
        // 1.sayfa url inin  https://www.bestbuy.com/ a eşit olduğunu test edin

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTesti(){
        //2. titleTest=> sayfa başlığının "Rest" içermediğini test edin

        String unexpectedİçerik="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unexpectedİçerik));
    }

    @Test
    public void logoTesti(){
        //3. logoTest=> BestBuy logosunun görüntülendiğini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisLinkTesti(){
        //4.FrancaisLinkTest=> Fransızca linkin görüntülendiğini test edin
        WebElement francaisLinkElementi= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisLinkElementi.isDisplayed());
    }
}
