package Task_yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reusable.ReusableMethod;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.LocalDate;

public class CitySelectPage {

    static   WebDriver driver;
    static ReusableMethod resue;

    public CitySelectPage(WebDriver driver) {
        this.driver = driver;
        this.resue = new ReusableMethod(driver);
    }

    public void clearLoginPopup() throws IOException {
        resue.takeScreenshot("Homepage");
            try {
                WebElement logInPopup = driver.findElement(By.xpath("//img[@alt='cross']"));
            resue.waitvisiblityOfElement(logInPopup);
            resue.jsClick(logInPopup);
            } catch (Exception e) {
                System.out.println("Login popup is not appear");
            }
    }
    public void departureFrom(String from) throws InterruptedException, IOException {
        WebElement busBtn = driver.findElement(By.xpath("//span[text()='Bus']"));
        resue.waitforClickable(busBtn).click();
        Thread.sleep(3000);
        WebElement depart = driver.findElement(By.xpath("//div[contains(@aria-label,'Depart From')]"));
        depart.click();
        WebElement departfrom = driver.findElement(By.xpath("//input[@id='input-with-icon-adornment']"));
        departfrom.sendKeys(from);
        WebElement boardingPoint = driver.findElement(By.xpath("//div[contains(text(),'"+from+"')]"));
        resue.jsClick(boardingPoint);
        resue.takeScreenshot("boarding point");
    }
    public void designationTo(String to) throws InterruptedException, IOException {
        WebElement depart = driver.findElement(By.xpath("//div[contains(@aria-label,'Going To')]"));
        depart.click();
        WebElement departfrom = driver.findElement(By.xpath("//input[@id='input-with-icon-adornment'][1]"));
        departfrom.sendKeys(to);

        WebElement reachingPoint = driver.findElement(By.xpath("//div[contains(text(),'"+to+"')]"));
        resue.waitforClickable(reachingPoint);
       resue.jsClick(reachingPoint);
        resue.takeScreenshot("dropping point ");

    }
public void selectJourneyDate(int day) throws InterruptedException, IOException {
    System.out.println("Booking Date :"+LocalDate.now());
    System.out.println("Travelling Date:"+LocalDate.now().plusDays(4));
    WebElement busBookingDate = driver.findElement(By.id("BusBookingDate"));
    busBookingDate.click();
    int travellingDate = LocalDate.now().plusDays(day).getDayOfMonth();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[text()='"+travellingDate+"']")).click();
           resue.takeScreenshot("Travelling day");
    WebElement searchBtn = driver.findElement(By.xpath("//button[text()='Search']"));
            resue.jsClick(searchBtn);

}


}


