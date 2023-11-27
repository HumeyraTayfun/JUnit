package tests.day06;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c05_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTesti(){
        //  1- https://testotomasyonu.com/droppable adresine gidelim
        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        //4- Sayfayi yenileyin
        // 5- “Not Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        // 6- “Drop Here” yazisinin degismedigini test edin


        //  1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get(" https://testotomasyonu.com/droppable ");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement acceptableElementi= driver.findElement(By.id("draggable2"));
        WebElement taşınacakHedefAlan=driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(acceptableElementi,taşınacakHedefAlan).perform();
        ReusableMethods.bekle(1);

        //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedAlanYazısı="Dropped!";
        String actualAlanYazısı=taşınacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazısı,actualAlanYazısı);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
           ReusableMethods.bekle(1);
        // 5- “Not Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement notAcceptableElementi=driver.findElement(By.id("draggable-nonvalid2"));
        taşınacakHedefAlan=driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(notAcceptableElementi,taşınacakHedefAlan).perform();

        // 6- “Drop Here” yazisinin degismedigini test edin
        expectedAlanYazısı="Drop Here";
         actualAlanYazısı=taşınacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazısı,actualAlanYazısı);
        ReusableMethods.bekle(5);




    }
}
