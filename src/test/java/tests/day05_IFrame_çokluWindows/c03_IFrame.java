package tests.day05_IFrame_çokluWindows;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class c03_IFrame extends TestBase {

    @Test
    public void test01(){
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o iframe'e gecis yapalim
        WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        //3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iFrameList.size());
        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        //5) ilk iframe'den çıkıp ana sayfaya dönünüz


    }
}
