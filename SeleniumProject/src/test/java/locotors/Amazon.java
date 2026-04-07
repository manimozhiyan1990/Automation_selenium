package locotors;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Amazon {
    static WebDriver driver;

    public static void homePageScreenShot(String screenShot) throws IOException {
        TakesScreenshot Image = (TakesScreenshot) driver;
        File HS = Image.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\Amazon\\homepage\\" + screenShot+".png");
        Files.copy(HS, path);
    }

    public static void homePage() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        Thread.sleep(2000);
        homePageScreenShot("image1");

        Thread.sleep(3000);
        driver.close();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        homePage();

    }
}
