package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C03_getMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
           Selenium 4.12 versiyonu ile
           kendi Webdriver'ini da olusturabiliyor

           Yani artık dısardan bir webdriver tanımlama MECBURİYETİ kalmadi

           ANCAK... sirketlerin pek cogu kendilerine ozel olarak
           satin aldiklari webdriver'lari kullanabiliyor.

           Biz bu duruma alişmak icin
           Selenium webdriver yerine indirdigimiz driver.exe dosyasını kullanmaya devam edecegiz
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);

        // System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle()); // 261D0E6C3B9B0C1D1E508B2495EE8BBA
        // Window handle degeri : selenium'un olusturdugu her webdricer objesine verdigi
        //                        unique bir kod'dur
        //                        Biz bu degerleri birden fazla sayfa acilirsa'sayfalar arasında gecis yapmak icin kullanacagız

        System.out.println(driver.getWindowHandles()); // [261D0E6C3B9B0C1D1E508B2495EE8BBA]
        // aktif webdriver objesının actıgı TUM SAYFALARIN window handle degerini getirir
        Thread.sleep(3000);
        driver.quit();
    }
}
