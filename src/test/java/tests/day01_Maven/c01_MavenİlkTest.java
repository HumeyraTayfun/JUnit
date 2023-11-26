package tests.day01_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01_MavenİlkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // urlin testotomasyonu içerdiğini test edin
        String expectedUrlİçerik="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlİçerik)){
            System.out.println("Url testi passed");//Url testi passed
        }else{
            System.out.println("Url testi failed");
        }

        //sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();
    }
}
