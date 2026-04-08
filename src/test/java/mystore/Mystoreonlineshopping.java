package mystore;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mystoreonlineshopping {
    static WebDriver driver;

public  static void screenShot(){

}
public static void jsScroll(WebElement Element){
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView()",Element);


}
public static void windowhnadle(int Index){
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(Index));
    }

    public static void handles() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //error stale element not found
        driver.get("https://www.mystore.in/");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='searchtext']"));
        Thread.sleep(2000);
        searchButton.sendKeys("Mobile");
        searchButton.sendKeys(Keys.ENTER);
        List<WebElement> totalProducts = driver.findElements(By.xpath("//a[@class='twoline_ellipsis']"));

        for(WebElement product : totalProducts){
            System.out.println(  product.getText());
            System.out.println();

        }

        WebElement product1 = driver.findElement(By.xpath("//a[contains(@class,'twoline_ellipsis') and contains(.,' Galaxy M06')]"));
      jsScroll(product1);
      Thread.sleep(2000);
      product1.click();
        Thread.sleep(3000);
        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        handles();

    }
}
