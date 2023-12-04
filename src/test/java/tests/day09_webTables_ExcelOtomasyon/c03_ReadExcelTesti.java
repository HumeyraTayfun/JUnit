package tests.day09_webTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class c03_ReadExcelTesti {
    Sheet sayfa1;

    @Test
    public void readExcelTesti() throws IOException {
        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //  - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        //  - Satir sayisini bulalim
        // samuanın baskentının Apıa oldugunu test edin
        //- Fiziki olarak kullanilan satir sayisini bulun
        //  - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


        String dosyaYolu = "src/test/java/tests/day09_webTables_ExcelOtomasyon/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("sayfa1");


        // 1.satirdaki 2.hucreye gidelim ve yazdiralim

        System.out.println(sayfa1.getRow(0).getCell(1));
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucreStr = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("string ie yazı " + istenenHucreStr);

        //  - 2.satir 4.cell’in afganistan’in baskenti kabil oldugunu test edelim
        String expectedCell = "Kabil";
        String actualCell = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedCell, actualCell);

        //  - Satir sayisini bulalim
        int satırSayısı = sayfa1.getLastRowNum();
        System.out.println("satır sayısı :" + (satırSayısı + 1));
        // samuanın baskentının Apıa oldugunu test edin
        String expectedBaskent = "Apia";
        String actualBaskent = "";
        for (int i = 0; i < satırSayısı; i++) {
            String ulkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (ulkeIsmi.equals("Samua")) {
                actualBaskent = sayfa1.getRow(i).getCell(1).toString();

                Assert.assertEquals(expectedBaskent, actualBaskent);
            }

        }
        //- Fiziki olarak kullanilan satir sayisini bulun
        satırSayısı = sayfa1.getPhysicalNumberOfRows();
        System.out.println("fiziki satır sayısı " + satırSayısı);
        //  - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        //      - Verdigimiz ingilizce ulke ismi ve dil tercihine gore
        //        baskent ismini bize donduren bir method olusturun
        // System.out.println(baskentBul("Peru", "ingilizce"));


        // System.out.println(ulkeBul("sanaa","türkçe"));
       System.out.println(ulkeBul("Abu Dhabı", "ingilizce"));
       // System.out.println(ulkeBul("Abu Dabi", "türkçe"));
        System.out.println(ulkeBul("Bucharest","ingilizce"));
       // System.out.println(ulkeBul("taşkent","türkçe"));

    }

    public String baskentBul(String ulkeAdi, String dilTercihi) {

        String satirdakiUlkeAdi;
        String baskentAdı = "";

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {
            satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiUlkeAdi.equalsIgnoreCase(ulkeAdi)) {
                if (dilTercihi.equalsIgnoreCase("ingilizce")) {
                    baskentAdı = sayfa1.getRow(i).getCell(1).toString();

                } else {
                    baskentAdı = sayfa1.getRow(i).getCell(3).toString();
                }
            }

        }
        return baskentAdı;
    }


    public String ulkeBul(String baskentAdi, String dilTercihi) {

        String sutundakiBaskentAdı="";
        String ulkeAdi = "";
        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {
            sutundakiBaskentAdı= sayfa1.getRow(i).getCell(1).toString();
            if (sutundakiBaskentAdı.equalsIgnoreCase(baskentAdi)) {
                if (dilTercihi.equalsIgnoreCase("ingilizce")) {
                    ulkeAdi = sayfa1.getRow(i).getCell(0).toString();
                } else {
                    ulkeAdi = sayfa1.getRow(i).getCell(2).toString();
                }
            }

        }
        return ulkeAdi;

    }
}



