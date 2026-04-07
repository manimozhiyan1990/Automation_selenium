package district;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class District {

    WebDriver driver;
    ReusableMethod reuse;

    public District(WebDriver driver) {
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);
    }

    public void districtTicketBooking(String moviename) throws InterruptedException, IOException {

        driver.get("https://www.district.in/movies/chennai-movie-tickets");

        reuse.takeScreenshot("HomePage");

        WebElement login = driver.findElement(By.xpath("//div[@role='button']"));
        reuse.jsClick(login);

        WebElement enterMobileNumber = driver.findElement(By.name("mobileNumber"));
        reuse.waitForVisibleElement(enterMobileNumber);
        enterMobileNumber.sendKeys("7299230515");
        WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Continue']"));
        reuse.jsClick(continueBtn);
        reuse.waitForManualOTP();
        Thread.sleep(3000);
        WebElement continueBtnn = driver.findElement(By.xpath("//span[text()='Continue']"));
        reuse.waitForVisibleElement(continueBtnn);
        reuse.jsClick(continueBtnn);
        reuse.scrollByPixel(0, 1000);
        List<WebElement> moviesList = driver.findElements(By.xpath("//a[contains(@href,'movies')]//h5"));

        for (WebElement movie : moviesList) {

            System.out.println(movie.getText());

            if (movie.getText().toLowerCase().contains(moviename.toLowerCase())) {

                movie.click();
                break;
            }
        }

        reuse.takeScreenshot("MovieSelected");
    }
}