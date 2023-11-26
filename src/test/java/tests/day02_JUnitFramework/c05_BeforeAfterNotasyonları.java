package tests.day02_JUnitFramework;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c05_BeforeAfterNotasyonları {

        WebDriver driver;

        @Before
        public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
       @After
       public void tearDown(){
            driver.quit();
       }

        @Test
        public void wiseQuarterTesti() {

        driver.get("https://www.wisequarter.com");
        //titlenin Wise yazdıgını test edin
        String expectedTitleIçerik = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIçerik)) {
            System.out.println("wisequarter testi passed");
        } else {
            System.out.println("wisequarter testi failed");
        }
        ReusableMethods.bekle(1);

    }

        @Test
        public void testOtomasyonuTesti() {

        // test otomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");
        // titlenin Test Otomasyon içerdigini test edin
        String expectedTitleIçerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIçerik)) {
            System.out.println("test otomasyonu testi passed");
        } else {
            System.out.println("test otomasyonu testi failed");
        }
        ReusableMethods.bekle(1);

    }

        @Test
        public void googleTesti(){

        driver.get("https://www.google.com");

        // urlnın google yazdıgını test edin
        String expectedUrlIçerik="google";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIçerik)){
            System.out.println("google testi passed");
        }else{
            System.out.println("google testi failed");
        }
        ReusableMethods.bekle(1);

    }
    }






