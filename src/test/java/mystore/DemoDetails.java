package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoDetails {

    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mystore.in/en/next/contact");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Manimozhiyan");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Mani@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7299230515");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Scroll");
        driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("Automation testing ");
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        Thread.sleep(2000);
        submit.click();


    }
}
