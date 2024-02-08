package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_findElements {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapin
        System.setProperty("webdriver.chrome.driver.","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com adresine gidin
        driver.get("https://testotomasyonu.com");
        // shoes linkine tıklayın
        driver.findElement(By.partialLinkText("hoes")).click();

        // cıkan urunlerden 3.urune tıklayın
        // 3.urunu ozel olarak locate edemiyorsak, tum urunleri bir list'e atip
        // sonra listedeki 3.urunu secebiliriz

        List<WebElement> urunElementleriListesi = driver.findElements(By.className("prod-img"));

        // 3.elemente clik yapalım
        urunElementleriListesi.get(2).click();
        Thread.sleep(2000);
        // urun kısa acıklamarında case sensitive shoe gectıgını test edin

        WebElement urunDetaylarıElementi = driver.findElement(By.className("prod-detail"));

        String expectedIcerik = "shoe";
        String actualDetaylar = urunDetaylarıElementi.getText().toLowerCase();

        if (actualDetaylar.contains(expectedIcerik)){
            System.out.println("Urun detay testi PASSED");
        }else System.out.println("Urun detau testi FAILED");

        Thread.sleep(2000);
        driver.close();
    }
}
