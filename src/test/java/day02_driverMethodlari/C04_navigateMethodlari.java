package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigateMethodlari {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // title'in Otomasyon icerdigini test edin
        String expectedTitileIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitileIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        }else {
            System.out.println("Testotomasyonu titile testi FAILED");
        }

        // sonra Wisequarter anasayfaya gidin
        driver.navigate().to("https://www.wisequarter.com");

        // Url'in wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter URL testi PASSED");
        }else {
            System.out.println("wisequarter URL testi FAILED");
        }

        // tekrar testotomasyonu sayfasına donun
        driver.navigate().back();

        // url'in otomasyon icerdigini test edin

        expectedUrlIcerik = "otomasyon";
        actualUrl = driver.getCurrentUrl();
        if (actualTitle.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        }else {
            System.out.println("Testotomasyonu titile testi FAILED");
            System.out.println("actual Url : " + actualUrl);
        }

        // sayfayı kapatın

        Thread.sleep(2000);
        driver.quit();
    }
}
