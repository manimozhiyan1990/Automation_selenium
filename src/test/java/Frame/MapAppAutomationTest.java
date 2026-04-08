package Frame;

import district.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;

public class MapAppAutomationTest {
    WebDriver driver;
    ReusableMethod reuse;
    Actions actions;

    public MapAppAutomationTest(WebDriver driver) {
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);
        this.actions =new Actions(driver);
    }

    public void mapAutomation() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
        WebElement app = driver.findElement(By.name("app"));
        driver.switchTo().frame(app);
        Thread.sleep(1000);
        WebElement map = driver.findElement(By.xpath("//span[text()='Maps']"));
        map.click();
        driver.switchTo().defaultContent();
        reuse.takeScreenshot("Homepage");
        WebElement searchBox = driver.findElement(By.xpath("//input[@role='combobox']"));
        reuse.waitvisiblityOfElement(searchBox);
        searchBox.sendKeys("thirumullaivoyal", Keys.ENTER);

        reuse.waitvisiblityOfLocator(By.xpath("//h1"));
        WebElement direction = driver.findElement(By.xpath("//button[contains(@aria-label,'Directions')]"));
        Thread.sleep(3000);
        reuse.waitvisiblityOfElement(direction);
        reuse.jsClick(By.xpath("//button[contains(@aria-label,'Directions')]"));
        WebElement startingPoint = driver.findElement(By.xpath("//input[contains(@aria-label,'Starting point Your location')]"));
        startingPoint.click();
        startingPoint.sendKeys("Velachery",Keys.ENTER);
        Thread.sleep(2000);
        reuse.takeScreenshot("location");
        WebElement totalKm = driver.findElement(By.xpath("//div[contains(text(),'km')][1]"));
        reuse.waitvisiblityOfLocator(By.xpath("//h1"));
        Thread.sleep(3000);
        System.out.println(totalKm.getText());
        driver.navigate().refresh();
        WebElement close = driver.findElement(By.xpath("//button[@data-tooltip='Close directions']"));
        reuse.jsClick(close);
        Thread.sleep(2000);

        WebElement satelliteView = driver.findElement(By.xpath("//div[@class='s6ATEe']"));
        reuse.waitvisiblityOfElement(satelliteView);
        reuse.mouseHoverClick(satelliteView);
        driver.navigate().refresh();
        Thread.sleep(2000);
        reuse.takeScreenshot("Satelliteview");
        //actions.sendKeys(Keys.F5).perform();
        WebElement zoomOut = driver.findElement(By.xpath("//button[@aria-label='Zoom out']"));
        for (int i = 0; i <7 ; i++) {
            zoomOut.click();
            Thread.sleep(500);
        }
        reuse.takeScreenshot("Goolge Map zoom out");
        Thread.sleep(3000);
        WebElement zoomIn = driver.findElement(By.xpath("//button[@aria-label='Zoom in']"));

Thread.sleep(2000);
        for (int j = 0; j <10; j++) {
            reuse.mouseHoverClick(zoomIn);
            Thread.sleep(500);
        }
        reuse.takeScreenshot("Goolge Map zoom in");
//
//        WebElement mapzoom = driver.findElement(By.xpath("//canvas"));
//
//        actions.moveToElement(map).click().perform();
//        actions.scrollByAmount(0, 1000).perform();
//
   }


    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MapAppAutomationTest map = new MapAppAutomationTest(driver);
        map.mapAutomation();

        Thread.sleep(5000);

        // driver.quit();

    }
}
