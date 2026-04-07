package locotors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BookMyShow {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://in.bookmyshow.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("dummy")).sendKeys("chennai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-result-item='true']//span[text()='Chennai']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("https://in.bookmyshow.com/movies/chennai/youth/ET00485590-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='page-cta-container']//button[1]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
    }
}
