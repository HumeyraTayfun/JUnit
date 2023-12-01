package tests.day08_actions_faker_filetestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class c06_BilgisayardakiDosyayıTestEtme {

   // "C:\Users\pc\Downloads\ISTQB_AllChild (Kasım 2023).pdf"

    @Test
    public void test01(){

        String dosyaYolu="C:\\Users\\pc\\Downloads\\ISTQB_AllChild (Kasım 2023).pdf";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\ISTQB_AllChild (Kasım 2023).pdf";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
}

    }
