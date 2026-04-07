package screenshot;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotPractice {
    static WebDriver driver;

    public static void fullScreenShot(String ScreenShot) throws IOException {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File fulPage = sc.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\" + ScreenShot + ".png");
        Files.copy(fulPage, path);
    }

    public static void elementScreenShot(WebElement element, String Image) throws IOException {
        File elementpage = element.getScreenshotAs(OutputType.FILE);
        File path1 = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\"+Image+ ".png");
        Files.copy(elementpage,path1);
    }

    public static void coloufulValidation() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        fullScreenShot("Image1");
        Thread.sleep(2000);

        WebElement element1 = driver.findElement(By.xpath("//div[@class='Blh9Gf']"));
        elementScreenShot(element1,"image2");


        driver.close();
        System.out.println("manimozhiyan");
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        coloufulValidation();


    }

}