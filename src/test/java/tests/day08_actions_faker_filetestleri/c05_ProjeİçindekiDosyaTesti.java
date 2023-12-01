package tests.day08_actions_faker_filetestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class c05_ProjeİçindekiDosyaTesti {


    // projemiz icerisinde day10 package'i altinda
    // deneme.txt dosyasinin oldugunu test edin


    @Test
    public void filesExistTesti(){

       String dosyaYolu="C:\\Users\\pc\\com.team.127_JUnit\\src\\test\\java\\tests\\day08_actions_faker_filetestleri\\deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String dinamikYolu= System.getProperty("user.dir") +
                "\\src\\test\\java\\tests\\day08_actions_faker_filetestleri\\deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikYolu)));

    }

}
