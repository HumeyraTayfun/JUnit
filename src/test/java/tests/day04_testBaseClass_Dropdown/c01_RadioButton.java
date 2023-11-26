package tests.day04_testBaseClass_Dropdown;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01_RadioButton {
    // gerekli yapıyı oluşturun ve asagıdaki görevi tamamlayın
    // a. verilen web sayfasına gidin
    //   https://testotomasyonu.com/form
    // b. cinsiyet radio buttun elementlerini locate edin ve size uygun olani seçin
    // c. seçtiğiniz radio butonun seçili, ötekilerin seçili olmadığını test edin
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    public void radioButtonKutuTesti() {
        // a. verilen web sayfasına gidin
        //   https://testotomasyonu.com/form
        driver.get(" https://testotomasyonu.com/form");
        // b. cinsiyet radio buttun elementlerini locate edin ve radio butonu işaretleyerek size uygun olani seçin
        WebElement kadınRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement diğerRadioButton = driver.findElement(By.id("inlineRadio3"));
        kadınRadioButton.click();
        // c. seçtiğiniz radio butonun seçili, ötekilerin seçili olmadığını test edin
        Assert.assertTrue(kadınRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(diğerRadioButton.isSelected());
        ReusableMethods.bekle(2);
    }

    @Test
    public void radioButtonYazıTesti() {
        // a. verilen web sayfasına gidin
        //   https://testotomasyonu.com/form
        driver.get(" https://testotomasyonu.com/form");
        // b. cinsiyet radio buttun elementlerini locate edin ve yazıyı click ederek size uygun olani seçin
        WebElement kadınRadioYazıElementi = driver.findElement(By.xpath("//*[@for='inlineRadio1']"));
        kadınRadioYazıElementi.click();
        WebElement kadınRadioButton =driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement diğerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. seçtiğiniz radio butonun seçili, ötekilerin seçili olmadığını test edin
        Assert.assertTrue(kadınRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(diğerRadioButton.isSelected());
    }
}
