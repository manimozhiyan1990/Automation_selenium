package Task_yatra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class YatraMainBusBookingPage {
    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.yatra.com/");
        Thread.sleep(1000);

        //object
        CitySelectPage city = new CitySelectPage(driver);
        BusSelectPage busType      = new BusSelectPage(driver);
        SeatSelectionPage booking = new SeatSelectionPage(driver);
        PassengerDetailsPage details = new PassengerDetailsPage(driver);
      // Method calling
        city.clearLoginPopup();
        city.departureFrom("Chennai");
        city.designationTo("Bangalore");
        city.selectJourneyDate(5);

        busType.ChooseBusType("AC Sleeper");
        busType.getLowestfareBus();

        booking.selectSeat();
        booking.boardingDropingPlace();

        details.bookingDetails();
        details.proceedForPayment();


        System.out.println("program has been successfully completed ");
    }
}