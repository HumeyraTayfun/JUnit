package tests.day03_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class c03_Assertions {

    @Test
    public void test01(){
        // emeklilik yaşı 65 olsun
        // 70 yaşındaki bir kişinin emekli olabildiğini test edin

        int yaş=70;
        Assert.assertTrue(yaş>65);// test passed

        int sayı1=20;
        int sayı2=30;
        Assert.assertTrue(sayı1>sayı2);//failed

        String actualUrl="https://www.testotomasyonu.com/";
        Assert.assertTrue(actualUrl.contains("testotomasyonu"));//passed

        // url nin wisequarter içermediğini test edin

        Assert.assertFalse(actualUrl.contains("wisequarter"));//passed

        // urlnın https://testotomasyonu.com/ oldugunu test edin

        Assert.assertEquals("https://www.testotomasyonu.com/",actualUrl);

        // urlnın https://www.testotomasyonu.com/ olmadıgını test edin
        Assert.assertNotEquals("https://www.testotomasyonu.com/",actualUrl);//passed
    }
}
