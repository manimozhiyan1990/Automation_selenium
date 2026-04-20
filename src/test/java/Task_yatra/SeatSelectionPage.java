package Task_yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reusable.ReusableMethod;

import java.io.IOException;

public class SeatSelectionPage {
    static WebDriver driver;
    static ReusableMethod resue;

    public SeatSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.resue = new ReusableMethod(driver);
    }

    public void selectSeat(){

        WebElement filterlowestPrice = driver.findElement(By.xpath("//span[text()='Price']"));
        resue.jsClick(filterlowestPrice);

        WebElement selectSeatBtn = driver.findElement(By.xpath("//div[text()='Select Seat'][1]"));
        resue.jsClick(selectSeatBtn);

        WebElement seatselect = driver.findElement(By.xpath("//li[contains(@class,'sleeper Sleeper')]"));

        resue.mouseHoverClick(seatselect);

    }

    public void boardingDropingPlace() throws InterruptedException, IOException {
        WebElement boardingPoint = driver.findElement(By.xpath("//label[contains(text(),'Boarding')]/following::select[1]"));
        Select select = new Select(boardingPoint);
        select.selectByIndex(2);
        Thread.sleep(1000);
        WebElement dropingPoint = driver.findElement(By.xpath("//label[contains(text(),'Dropping')]/following::select[1]"));
      resue.selectByIndex(dropingPoint,1);

       try {
           WebElement conformSeat = driver.findElement(By.xpath("//button[normalize-space()='Confirm Seats'] "));
           resue.mouseHoverClick(conformSeat);
       } catch (Exception e) {
           resue.takeScreenshot("Seates Are not Availble");
           System.out.println("Select seat button not visible ");
       }

        }
}
