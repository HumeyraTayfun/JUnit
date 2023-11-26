package tests.day03_JUnitAssertions;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01_BeforeAfterNotasyonları {
    //1.test otomasyonu sayfasına gidin
    //2. phone.shoes.dress için arama yapın
    //3. arama sonucunda ürün bulunabildiğini test edin
    // 4.sayfayı kapatın


    WebDriver driver;
    @Before
    public void setup() {
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
    public void phoneTesti(){
        //1.test otomasyonu sayfasına gidin
        driver.get("https:www.testotomasyonu.com");
        //2. phone için arama yapın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        WebElement aramaSonuçElementi=driver.findElement(By.className("product-count-text"));
        String aramaSonuçSayısıStr=aramaSonuçElementi.getText().replaceAll("\\D","");
        int aramaSonuçSayısı=Integer.parseInt(aramaSonuçSayısıStr);

        if(aramaSonuçSayısı>0){
            System.out.println("phone testi passed");
        }else{
            System.out.println("phone testi failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);



    }

    @Test
    public void shoesTesti(){
        //1.test otomasyonu sayfasına gidin
        driver.get("https:www.testotomasyonu.com");
        //2. shoes için arama yapın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes"+ Keys.ENTER);
        WebElement aramaSonuçElementi=driver.findElement(By.className("product-count-text"));
        String aramaSonuçSayısıStr=aramaSonuçElementi.getText().replaceAll("\\D","");
        int aramaSonuçSayısı=Integer.parseInt(aramaSonuçSayısıStr);

        if(aramaSonuçSayısı>0){
            System.out.println("shoes testi passed");
        }else{
            System.out.println("shoes testi failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);

    }

    @Test
    public void dressTesti(){
        //1.test otomasyonu sayfasına gidin
        driver.get("https:www.testotomasyonu.com");
        //2. dress için arama yapın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+ Keys.ENTER);
        WebElement aramaSonuçElementi=driver.findElement(By.className("product-count-text"));
        String aramaSonuçSayısıStr=aramaSonuçElementi.getText().replaceAll("\\D","");
        int aramaSonuçSayısı=Integer.parseInt(aramaSonuçSayısıStr);

        if(aramaSonuçSayısı>0){
            System.out.println("dress testi passed");
        }else{
            System.out.println("dress testi failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);


    }




}