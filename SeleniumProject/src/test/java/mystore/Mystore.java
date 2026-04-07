package mystore;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mystore {
    static WebDriver driver;

    public static void takeScreenshot(String ImageName) throws IOException {
        TakesScreenshot image = (TakesScreenshot) driver;
        File screenshotAs = image.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\mystore\\" + ImageName + ".png");
        Files.copy(screenshotAs, path);

    }

    public static void jsScroll(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", Element);
    }
    public static void jsclick(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", Element);
    }

    public static void jsScrollBypixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void windowHandling(int index) {
        Set<String> windowsHandles = driver.getWindowHandles();
        List<String> tab = new ArrayList<>(windowsHandles);
        driver.switchTo().window(tab.get(index));
    }

    public static void Handling() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mystore.in/");
        // String parent = driver.getWindowHandle();
        driver.manage().window().maximize();
        Thread.sleep(1500);
        takeScreenshot("Image 1");
        WebElement SellonOndc = driver.findElement(By.xpath("//a[text()='Sell on ONDC']"));
        SellonOndc.click();
        windowHandling(1);
        WebElement MystoreNext = driver.findElement(By.xpath("//a[text()='MystoreNext']"));
        MystoreNext.click();
        Thread.sleep(2000);

        windowHandling(2);
//        WebElement pricing = driver.findElement(By.xpath("//li[contains(@class,'nav-item parent-li d-flex')]//a[text()='Pricing']"));
//        takeScreenshot("Image 2");
//        pricing.click();
//        Thread.sleep(3000);
//
        WebElement demo = driver.findElement(By.xpath("//a[text()='Book a Demo']"));
        Thread.sleep(2000);
        jsScrollBypixel();
        // jsScroll(demo);
        jsclick(demo);

        // demo.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Manimozhiyan");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Mani@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7299230515");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Scroll");
        driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("Automation testing ");
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        Thread.sleep(2000);
        takeScreenshot("Image 3");
        Thread.sleep(2000);
        // jsScroll(submit);
        //  jsScrollBypixel();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submit);
        Thread.sleep(1200);


      //  windowHandling(0);
        // driver.close();
        // driver.switchTo().window(parent);
        // windowHandling(1);
        // driver.navigate().refresh();
        WebElement backToHome = driver.findElement(By.xpath("//a[contains(@class,'back-to-mystore')]"));
        backToHome.click();
        takeScreenshot("Image 4");


        Thread.sleep(2000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Handling();
    }
}
