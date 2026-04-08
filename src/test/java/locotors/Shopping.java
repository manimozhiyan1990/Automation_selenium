package locotors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Shopping {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Manimozhiyan");
        driver.findElement(By.id("LastName")).sendKeys("Duraisamy");
        driver.findElement(By.id("Email")).sendKeys("Manimozhiyan220@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        Thread.sleep(3000);
        driver.findElement(By.id("register-button")).click();
        driver.findElement((By.className("button-1 register-continue-button"))).click();
        driver.findElement(By.xpath("//a[@href='/25-virtual-gift-card']")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-2']")).click();
    }
}
