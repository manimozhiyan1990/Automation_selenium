package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BacktoHome {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mystore.in/en/next/contact");
        Thread.sleep(3000);
        WebElement homepage = driver.findElement(By.xpath("//a[contains(@class,'back-to-mystore')]"));
        homepage.click();

        Thread.sleep(5000);

        driver.quit();

    }
}
