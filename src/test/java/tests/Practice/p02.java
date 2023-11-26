package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class p02 {
    // BeforeClass ile driver'i oluşturun ve class icinde static yapin
    // Maximize edin ve 10 sn bekletin
    // http://www.babayigit.net/testdocs adresine gidin
    // 1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
    //2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
    //3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
    // AfterClass ile kapatin.
    static WebDriver driver;
    WebElement searchBox;
    String filmName;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void before() {
        driver.get("http://www.babayigit.net/testdocs");
        searchBox = driver.findElement(By.xpath("//input[@id='search']"));
    }

    @After
    public void after() {
        System.out.println(filmName+ "sonuç sayısı: "+ driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
        //Yaklaşık 506.000.000 sonuç bulundu (0,37 saniye)
    }

    @Test
    public void test01() {
        filmName="12 Angry Men";
        searchBox.sendKeys(filmName +"" + Keys.ENTER);
    }

    @Test
    public void test02() {
        filmName="Vizontele";
        searchBox.sendKeys(filmName + Keys.ENTER);
    }

    @Test
    public void test03() {
        filmName="3 Idiots";
        searchBox.sendKeys(filmName + Keys.ENTER);

    }
}
