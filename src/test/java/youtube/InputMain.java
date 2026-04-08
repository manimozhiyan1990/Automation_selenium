package youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InputMain {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
      //  driver.get("https://www.google.com/");
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        YoutubeAutomation youtube = new YoutubeAutomation(driver);

        youtube.youTubeSongsAutomate("mutta kalaki");
       // youtube.youTubeSongsAutomate("O podu");

      //  Thread.sleep(4000);
     //   driver.quit();
    }
}
