package Task_youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class YouTubeTestPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        YouTubeAutomationPage yt = new YouTubeAutomationPage(driver);
        List <String> songs = new ArrayList<>();
        //  5 songs
     songs.add("Kodi Aruvi");
     songs.add(  "Theekkoluthi ");

//                "Chillanjirukkiye",
//                "Brahmakalasha Tamil"
//
//
        for (String song : songs) {
            yt.playSong(song);
        }

        driver.quit();
    }
}