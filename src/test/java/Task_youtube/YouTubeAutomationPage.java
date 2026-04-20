package Task_youtube;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import reusable.ReusableMethod;

import java.time.Duration;
import java.util.List;

public class YouTubeAutomationPage {

    WebDriver driver;
    ReusableMethod reuse;



    public YouTubeAutomationPage(WebDriver driver) {
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);

    }

    By searchBox = By.name("search_query");
    By videoTitles = By.xpath("//a[@id='video-title']");
    By adShow =By.xpath("//div[text()='Sponsored']");
    By muteBtn = By.xpath("//button[@class='ytp-volume-icon ytp-button']");
    By unmuteBtn = By.xpath("//button[@class='ytp-volume-icon ytp-button']");
    By skipBtn = By.xpath("//button[contains(@class,'ytp-ad-skip-button')]");
    By fullscreen = By.xpath("//button[contains(@class,'ytp-fullscreen-button ytp-button')]");


    public void searchSong(String song) {
        WebElement search = driver.findElement(searchBox);
        search.click();
        search.clear();
        search.sendKeys(song);
        search.sendKeys(Keys.ENTER);
    }

    public void clickVideo(String song) throws InterruptedException {

        Thread.sleep(3000); // wait results load

        List<WebElement> videos = driver.findElements(videoTitles);

        for (WebElement video : videos) {

            String songTitle = video.getText();

            if (songTitle.toLowerCase().contains(song.toLowerCase())) {

                reuse.jsScroll(video);
                reuse.jsClick(video);

                System.out.println("Clicked: " + songTitle);
                return;
            }
        }
        System.out.println("Video not found: " + song);
        Thread.sleep(1000);

        driver.findElement(fullscreen).click();
    }

    public void handleAd() throws InterruptedException {
        WebElement adshowing = driver.findElement(adShow);
        reuse.mouseHover(adshowing);
      reuse.waitvisiblityOfElement(adshowing);

        if (adshowing.isDisplayed()) {
            try {
                WebElement mute = driver.findElement(muteBtn);
                reuse.waitforClickable(mute);
                mute.click();
                System.out.println("Muted");
            } catch (Exception e) {
                System.out.println("Mute not found");
            }
            try {
                WebElement skip = driver.findElement(skipBtn);
                skip.click();
            } catch (Exception e) {
                System.out.println("Skip not available yet");
            }

            try {
                WebElement mute = driver.findElement(unmuteBtn);
                mute.click();
                System.out.println("Unmuted");
            } catch (Exception e) {
                System.out.println("Unmute not needed");
            }
        }
         driver.findElement(fullscreen).click();
        }
        public void playSong (String song) throws InterruptedException {

            searchSong(song);
            clickVideo(song);
            handleAd();

            Thread.sleep(20000);
        }
    }
