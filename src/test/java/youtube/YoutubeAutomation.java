package youtube;
import district.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeAutomation {
    WebDriver driver;
    ReusableMethod reuse;

    public YoutubeAutomation(WebDriver driver){
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);

    }

    public void youTubeSongsAutomate(String songs) throws InterruptedException {
//        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
//        WebElement app = driver.findElement(By.name("app"));
//        driver.switchTo().frame(app);
//        Thread.sleep(1000);
//        WebElement map = driver.findElement(By.xpath("//span[text()='YouTube']"));
//        map.click();
//        driver.switchTo().defaultContent();

        WebElement searchQuery = driver.findElement(By.name("search_query"));
        searchQuery.sendKeys(songs);
        driver.findElement(By.xpath("//button[@title='Search']")).click();
        WebElement song1 = driver.findElement(By.xpath("//a[contains(text(),'Mutta Kalakki Music Video')]"));
        song1.click();
        System.out.println("");



    }
}
