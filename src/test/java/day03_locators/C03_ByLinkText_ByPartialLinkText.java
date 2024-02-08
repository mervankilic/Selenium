package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText_ByPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlamari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");
        // shoes linkine tiklayin

        // driver.findElement(By.linkText("Shoes")).click();
        // driver.findElement(By.linkText("hoes")).click();
        // eger By.linkText() kullanırsanız, link uzerindeki text'i birebir aynı yazmamız gerekir
        // bosluk, ? gibi karakterler varsa onlar da mutlaka yazilmalidir

        // driver.findElement(By.partialLinkText("hoes")).click();
        // driver.findElement(By.partialLinkText("oes")).click();
        // driver.findElement(By.partialLinkText("ho")).click();
        WebElement shoesLinki = driver.findElement(By.partialLinkText("oe"));
        shoesLinki.click();

        // By.partialLinkText() kullanildiginda
        // link uzerindeki yazinin tamamina ihtiyac yoktur
        // Yazinin, istedigimiz webelementi unique olarak bulabilecegimiz
        // herhangi bir parcasini kullanmamiz yeterli olur

        // acilan sayfada Title'in Shoes icerdigini test edin

        String expectedTitleIcerik = "Shoes";
        String actualTtile = driver.getTitle();

        if (actualTtile.contains(expectedTitleIcerik)){
            System.out.println("Shoes testi PASSED");
        }else System.out.println("Shoes testi FAILED");

        // Shoes linkinin bu sayfada da erişilebilir oldugnu test edin

        /*
           Bir webelementi locate ettikten sonra
           sayfayi yenileme veya yeni bir sayfaya gitme gibi işlmeler yaparsak
           dirver daha onceden yaptigimiz locate'leri KULLANAMAYABILIR
           ve bize "StaleElementReferenceException" verir

           bu durumda locate ve elemente kayıt işlemini YENIDEN YAPMALIYIZ
         */
        shoesLinki = driver.findElement(By.partialLinkText("oe"));
        if (shoesLinki.isEnabled()){ // StaleElementReferenceException
            System.out.println("Shoes linki erişim testi PASSED");
        }else System.out.println("Shoes linki erişimi testi FAILED");



        Thread.sleep(3000);
        driver.close();
    }
}
