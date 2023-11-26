package tests.day04_testBaseClass_Dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class c03_DropDownMenu extends TestBase {

    @Test
    public void dropdownTesti() {

        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form ");

        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // - ilk adim : kullanacagimiz ddm locate edip kaydedelim
        WebElement doğumGünüDdm=driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        // - ikinci adim : bir select objesi olusturalim
        //                 parametre olarak locate etttigimiz ddm'yu yazalim
        Select selectGün=new Select(doğumGünüDdm);

        // -ucuncu adim : olusturdugumuz select objesi ile istenen islemleri yapin
        selectGün.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin
        WebElement ayDdm=driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy=new Select(ayDdm);
        selectAy.selectByVisibleText("Nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yılDdm=driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYıl= new Select(yılDdm);
        selectYıl.selectByVisibleText("1990");

        //  4. Secilen degerleri konsolda yazdirin
        System.out.println("seçilen tarih: "+selectGün.getFirstSelectedOption().getText()+
                " "+ selectAy.getFirstSelectedOption().getText()+
                " "+ selectYıl.getFirstSelectedOption().getText());
        //     Dropdown menude secim yaptiktan sonra
        //     yapilan secimi yazdirmak isterseniz .getFirstSelectedOption().getText() kullaniriz
        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayOpsiyonElementleriList=selectAy.getOptions();
        System.out.println(ReusableMethods.stringlisteDönüştür(ayOpsiyonElementleriList));

        //seçilen tarih: 1990 Nisan 1990
        //[Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        // 6. ay dropdown menüsünün 30 oldugunu test edin

        Assert.assertEquals(30,ayOpsiyonElementleriList.size());

        ReusableMethods.bekle(5);

    }
}