package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Iframe {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Frames.html");

         //driver.switchTo().frame()
        WebElement frame = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mni");

        driver.switchTo().defaultContent();
    }
}
