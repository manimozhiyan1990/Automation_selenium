package locotors;

import reusable.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class XpathAxispractice {
    static WebDriver driver;
    static ReusableMethod reuse;


    public XpathAxispractice(WebDriver driver) {
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);


    }

    public static void selectorHubHeader() {
        WebElement products = driver.findElement(By.xpath("//span[normalize-space()='Products'] /ancestor::li[1]"));

        reuse.mouseHover(products);

    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        XpathAxispractice xpathAxis = new XpathAxispractice(driver);

        selectorHubHeader();

    }
}
