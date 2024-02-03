package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_manageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        /*
           Wait konusunu ilerde daha detayli anlatacagiz
           implicitlyWait() sayfanin yuklenmesini ve/veya
           arayacagimiz weblemeleri bulmak icin dinamik olarak tanimlanmis
           maximum bekleme suresidir.


           Asil amac bekleme degil gorevi yapmaktir

           burada tanımlanan sure gorevi yapmaya cabalayacagı max suredir
           bu sure icerisinde gorevi yapamazsa
           exception firlatır
         */

        System.out.println("ilk bastaki konum : "+ driver.manage().window().getPosition());
        System.out.println("ilk bastaki size : "+ driver.manage().window().getSize());
        Thread.sleep(2000);

        driver.manage().window().maximize();
        System.out.println("maximize konum : "+ driver.manage().window().getPosition());
        System.out.println("maximize size : "+ driver.manage().window().getSize());
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : "+ driver.manage().window().getPosition());
        System.out.println("fullscreen size : "+ driver.manage().window().getSize());
        Thread.sleep(2000);

        // pencereyi baslangıc noktası (50,100) ve size'i (1000,700) yapın

        driver.manage().window().setSize(new Dimension(1000,700));
        driver.manage().window().setPosition(new Point(50,100));

        System.out.println("ozel konum : "+ driver.manage().window().getPosition());
        System.out.println("ozel size : "+ driver.manage().window().getSize());

        System.out.println(driver.manage().window().getSize().getWidth());


        Thread.sleep(2000);
        driver.close();
    }
}
