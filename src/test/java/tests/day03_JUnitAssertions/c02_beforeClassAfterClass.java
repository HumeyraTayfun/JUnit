package tests.day03_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c02_beforeClassAfterClass {
    //3 farklı test metodu olusturarak asagıda verılen görevi tamamlayın
    //1. testotomasyonu.com sayfasına gidin
    //urlnın testotomasyonu içerdiğini test edin
    //2. phone için arama yaptırın ve arama sonucunda ürün bulunabıldıgını test edın
    //3.ilk ürüne tıklayın ve ürün açıklamasında case sensitive olmadan phone gectıgını test edin
     static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass

       public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        //1. testotomasyonu.com sayfasına gidin
        //urlnın testotomasyonu içerdiğini test edin
        driver.get("https://www.testotomasyonu.com");
        String expectedUrlİçerik="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrlİçerik)){
            System.out.println("url testi passed");
        }else{
            System.out.println("url testi failed");
            throw new AssertionFailedError();
        }

    }
    @Test
    public void test02(){
        //2. phone için arama yaptırın ve arama sonucunda ürün bulunabıldıgını test edın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        WebElement aramaSonucuElementi= driver.findElement(By.className("product-count-text"));
        String aramaSonuçSayısıStr=aramaSonucuElementi.getText().replaceAll("\\D","");
        int aramaSonuçSayısı=Integer.parseInt(aramaSonuçSayısıStr);
        if (aramaSonuçSayısı>0){
            System.out.println("Arama testi passed");
        }else{
            System.out.println("Arama testi failed");
        }
    }

    @Test
    public void test03(){
        //3.ilk ürüne tıklayın ve ürün açıklamasında case sensitive olmadan phone gectıgını test edin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        WebElement ürünAçıklamaElementi= driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));
        String expectedÜrünİçerik="phone";
        String ürünAçıklama=ürünAçıklamaElementi.getText().toLowerCase();

        if (ürünAçıklama.contains(expectedÜrünİçerik)){
            System.out.println("ürün açıklama testi passed");
        }else{
            System.out.println("ürün açıklama testi failed");
            throw new AssertionFailedError();
        }
    }



}
