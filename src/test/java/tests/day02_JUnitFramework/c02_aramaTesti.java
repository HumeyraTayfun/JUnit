package tests.day02_JUnitFramework;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c02_aramaTesti {
    public static void main(String[] args) throws InterruptedException {
        //1.testotomasyonu.com anasayfasına gidelim
        //2.arama kutusunu locate edelim
        //3.phone ile arama yapalım
        //4.bulunan sonuç sayısını yazdıralım
        //5.ilk urunu tıklayalım
        //6.ürünün stokta var oldugunu test edelim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1.testotomasyonu.com anasayfasına gidelim
        driver.get("https://www.testotomasyonu.com");

        //2.arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='global-search']"));
        //3.phone ile arama yapalım
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        //4.bulunan sonuç sayısını yazdıralım
        WebElement sonuçYazıElementi= driver.findElement(By.className("product-count-text"));
        System.out.println(sonuçYazıElementi.getText());
        //5.ilk urunu tıklayalım
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();
        //6.ürünün stokta var oldugunu test edelim
        WebElement ürünstokElementi= driver.findElement(By.xpath("(//span[@class='heading-xs '])[1]"));
        System.out.println(ürünstokElementi.getText());
        String expectedStokDurumu="Availibility: In Stock";
        String actualStokDurumu=ürünstokElementi.getText();

        if (expectedStokDurumu.equals(actualStokDurumu)){
            System.out.println("Ürün stok testi passed");
        }else{
            System.out.println("Ürün stok testi failed");
        }

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
