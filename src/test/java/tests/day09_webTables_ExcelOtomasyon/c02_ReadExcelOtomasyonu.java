package tests.day09_webTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class c02_ReadExcelOtomasyonu {

    @Test
    public void excelOtomasyonTesti() throws IOException {

        String dosyaYolu="src/test/java/tests/day09_webTables_ExcelOtomasyon/ulkeler.xlsx";

        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("sayfa1");
        Row üçüncüSatır=sayfa1.getRow(3);
        Cell ikinciData=üçüncüSatır.getCell(2);
        System.out.println(ikinciData);
    }
}
