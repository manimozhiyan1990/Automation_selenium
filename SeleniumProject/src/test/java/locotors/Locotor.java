package locotors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Locotor {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@title='Live Cricket Score']")).click();
        Thread.sleep(1000);
        driver.navigate().to("https://www.cricbuzz.com/premium-subscription/user/login");
        driver.findElement(By.xpath("//input[@placeholder='Email Id/ Mobile Number']")).sendKeys("manimozhiyan1990@gmail.com");
        driver.quit();


    }
}
