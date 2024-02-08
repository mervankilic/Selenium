package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_ByClassnameLocator {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu.com sayfasına gidin
        driver.get("https://www.testotomasyonu.com");
        // arama kutusuna phone yazıp aratın

        WebElement aramakutusu = driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone" + Keys.ENTER);
        // arama yapıldıktan sonra, sol tarafta cıkan Categories menusunbdeki
        // katagori sayısının 8 oldugunu test edın

        int expectedKatagoriSayisi = 8;
        List<WebElement> kategoriElementleriList = driver.findElements(By.className("acc_head"));
        int actualKatagoriSayisi = kategoriElementleriList.size();

        if (expectedKatagoriSayisi == actualKatagoriSayisi){
            System.out.println("Katagori sayisi testi PASSED");
        }else {
            System.out.println("Katagori sayisi testi FAILED");
            System.out.println("Actual katagori sayisi : "+ actualKatagoriSayisi);
        }


        // katagorileri yazdırın

        System.out.println(kategoriElementleriList);

        // Bu List webelementler'den olusuyor
        // webelementler uzerindeli yaziyi direk yazdıramayız
        // her bir webelementi eele alip, uzerindeki yaziyi yazdirmamiz gerekir

        /*
        yazdırma işlemini bir for-each loop il yapabiliriz
        ama biz bu işlemi çok kullanacagımız için
        bir method olusturup
        webelementlerden olusan listeyi
        String'lerden olusan bir listeye cevirdik



        for (WebElement each : kategoriElementleriList
             ) {
            System.out.println(each.getText());
        }


         */

        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriList));

        Thread.sleep(3000);
        driver.close();

    }
}
