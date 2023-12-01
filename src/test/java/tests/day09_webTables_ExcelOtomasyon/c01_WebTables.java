package tests.day09_webTables_ExcelOtomasyon;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class c01_WebTables extends TestBase {

   //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
      //      2. Headers da bulunan basliklari yazdirin
 // 3. 3.sutunun basligini yazdirin
//  4. Tablodaki tum datalari yazdirin
//  5. Tabloda kac tane cell (data) oldugunu yazdirin
 // 6. Tablodaki satir sayisini yazdirin
 // 7. Tablodaki sutun sayisini yazdirin
 // 8. Tablodaki 3.kolonu yazdirin
  //9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
   //10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        @Test
    public void webTablesTesti(){
            //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
            driver.get("https://testotomasyonu.com/webtables2");
            //      2. Headers da bulunan basliklari yazdirin

            List<WebElement> başlıkElementleri=driver.findElements(By.xpath("//div[@role='hdata']"));
            List<String> başlıkElementleriStr= ReusableMethods.stringlisteDönüştür(başlıkElementleri);
            System.out.println(başlıkElementleriStr.size());

            // 3. 3.sutunun basligini yazdirin
            System.out.println(başlıkElementleriStr.get(2));

           //  4. Tablodaki tum datalari yazdirin
            List<WebElement> dataElementleri=driver.findElements(By.xpath("//div[@role='tdata']"));
            List<String> dataElementleriStr=ReusableMethods.stringlisteDönüştür(dataElementleri);
           // System.out.println(dataElementleriStr);

            // 6. Tablodaki satir sayisini yazdirin
            List<WebElement> satırElementi=driver.findElements(By.xpath("//div[@role='trow']"));
           // List<String> satırSayısıStr=ReusableMethods.stringlisteDönüştür(satırElementi);
            System.out.println(satırElementi.size());

            // 7. Tablodaki sutun sayisini yazdirin

            System.out.println(başlıkElementleriStr.size());






        }
}
