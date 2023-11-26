package tests.Practice;

import org.junit.*;

public class p01 {
    // @BeforeClass tüm classlardan önce bır kere calısır
    // @AfterClass tum classlardan sonra bır kre calısır
    // @Before her classtan once bır kere calısır
    //@After her classtan sonra bır kere calısır
    // @Test metotlarımızı calıstırır

    @BeforeClass
    public static void setUp(){
        System.out.println("....test işlemleri başlatıldı......");
        System.out.println(" ");
        System.out.println(" ");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("......test işlemleri tamamlandı.....");
    }



    @Before
    public void before(){
        System.out.println(".....before.....");
        System.out.println("yeni bir test çalıştırılıyor");
    }
    @After
    public void after(){
        System.out.println("");
        System.out.println(".....After.....");
        System.out.println("");
    }





    @Test

    public void test01() {
        System.out.println("test01");
    }

    @Test

    public void test02() {
        System.out.println("test02");
    }

    @Test
    public void test03() {
        System.out.println("test03");

    }
}
