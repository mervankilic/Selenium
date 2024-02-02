package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_İlkTest {

    public static void main(String[] args) throws InterruptedException {

        // testotomasyonu anasayfasına giin
        // URL'in https://www.testotomasyonu.com oldugunu
        // ve Title'in test kelimesi icerdigini test edin

        // Her test için Mutlaka bir webdriver olusturulmali
        // ve gerekli ayarlamalari yapmaliyiz
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // testotomasyonu anasayfasına giin

        driver.get("https://www.testotomasyonu.com");


        // URL'in https://www.testotomasyonu.com oldugunu

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
            System.out.println("Actual URL : " + actualUrl);
        }

        // ve Title'in test kelimesi icerdigini test edin

        String expectedTtitleIcerigi = "test";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTtitleIcerigi)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }



        Thread.sleep(3000);
        driver.quit();

    }
}
