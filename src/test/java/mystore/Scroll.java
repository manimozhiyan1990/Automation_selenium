package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //error stale element not found
        driver.get("https://www.mystore.in/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
     while (true) {
          try{
              WebElement categary = driver.findElement(By.xpath("//div[contains(@class,'section-heading')]//a[@href='/browse/electronics']"));
              Thread.sleep(1000);
              categary.click();
              break;
          }
          catch (Exception e){
              js.executeScript("window.scrollBy(0,1000)");
              Thread.sleep(1500);
          }

     }
       Thread.sleep(5000);
        //driver.quit();
    }
}
