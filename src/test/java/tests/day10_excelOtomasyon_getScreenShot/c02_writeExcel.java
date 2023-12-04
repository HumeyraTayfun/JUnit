package tests.day10_excelOtomasyon_getScreenShot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class c02_writeExcel {
    @Test
    public void writeExcelTesti() throws IOException {
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek Sayfa1’deki 1.satira kadar gidelim

        String dosyaYolu="src/test/java/tests/day09_webTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1= workbook.getSheet("sayfa1");

        //4) 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).getCell(4).setCellValue(15000000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).getCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).getCell(4).setCellValue(54000);
        //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //10)Dosyayi kapatalim
        fos.close();
        fileInputStream.close();
        workbook.close();

    }


}
