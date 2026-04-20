package Task_makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;

public class MakeMyTripBooking {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);

        MakeMyTripAutomation mytrip = new MakeMyTripAutomation(driver);
        mytrip.BusTicketbooking("Chennai", "Bangalore");

        Thread.sleep(5000);
        // driver.quit();
    }
}
