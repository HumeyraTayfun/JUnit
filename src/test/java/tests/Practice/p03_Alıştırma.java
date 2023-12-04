package tests.Practice;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class p03_Alıştırma extends TestBase {
    @Test
    public void test01() {
        // gerekli yapıyı oluşturun ve aşağıdaki görevi tamamlayın
        // a. verilen web sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        ReusableMethods.bekle(2);

        //b. checkbox1 ve checkbox2 elementlerini locate edin
       driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
       driver.findElement(By.xpath("//input[@type='checkbox'][2]"));


        //c. checkbox1 seçili değilse onay kutusunu tıklayın
        //d. checkbox2 seçili değilse onay kutusunu tıklayın
        // e. cheksbox1 ve checkbox2 nin seçili olduğunu test edin
         WebElement checkboxKutusu1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
         checkboxKutusu1.click();
         ReusableMethods.bekle(1);
         Assert.assertTrue(checkboxKutusu1.isSelected());
           WebElement checkboxKutusu2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

           ReusableMethods.bekle(1);
           Assert.assertTrue(checkboxKutusu2.isSelected());
    }
}