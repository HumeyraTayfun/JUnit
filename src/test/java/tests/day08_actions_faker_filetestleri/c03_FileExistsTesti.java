package tests.day08_actions_faker_filetestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class c03_FileExistsTesti extends TestBase {

    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. logo.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

     @Test
    public void dosyaİndirmeTesti(){
         driver.get("https://the-internet.herokuapp.com/download");
         driver.findElement(By.xpath("//*[text()='logo.png']")).click();

         String dosyaYolu="C:\\Users\\pc\\Downloads\\logo.png";
         Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//test passed

     }

}
