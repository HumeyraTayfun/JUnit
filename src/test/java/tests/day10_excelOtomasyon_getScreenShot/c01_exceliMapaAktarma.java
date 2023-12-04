package tests.day10_excelOtomasyon_getScreenShot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class c01_exceliMapaAktarma {

    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu="src/test/java/tests/day09_webTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1= workbook.getSheet("sayfa1");

        // Ulkeler excel'indeki Turkce ulke isimleri ve
        // Turkce baskent isimlerini bir Map olarak kaydedin
        // Ulke isimleri key, baskent isimleri value olsun

        Map<String,String> ulkelerMap=new TreeMap<>();
        String satırdakiUlkeIsmı;
        String satırdakiBaskentIsmi;
        int sonSatırIndex=workbook.getSheet("sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatırIndex; i++) {
            satırdakiUlkeIsmı=workbook.getSheet("sayfa1").getRow(i).getCell(2).toString();
            satırdakiBaskentIsmi=workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satırdakiUlkeIsmı,satırdakiBaskentIsmi);

        }
        // Rusya'nin baskentinin Moskova oldugunu test edelim
        String expectedBaskent="Moskova";
        String actualBaskent=ulkelerMap.get("Rusya");
        Assert.assertEquals(expectedBaskent,actualBaskent);

        // Listede baskenti San Marino olan bir ulke oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

        // Listede Filipinler'in oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));




    }
}
