package Task_yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reusable.ReusableMethod;

import java.io.IOException;

public class PassengerDetailsPage {
    static WebDriver driver;
    static ReusableMethod resue;
    public PassengerDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.resue = new ReusableMethod(driver);
    }
    By EmailId = By.id("userEmail");
    By MobileNumber = By.id("userMobile");
    By travellerName = By.id("travellerName-0");
    By genderoption    = By.id("gender-0");

    public void bookingDetails() throws IOException {

        driver.findElement(EmailId).sendKeys("mani123@gmail.com");
        driver.findElement(MobileNumber).sendKeys("7299230515");
        driver.findElement(travellerName).sendKeys("Manimozhiyan");
        WebElement gender = driver.findElement(genderoption);

        gender.click();
        gender.sendKeys(Keys.ARROW_DOWN);
        gender.sendKeys(Keys.ENTER);
        Select ageSelect = new Select(driver.findElement(By.id("age-0")));
        ageSelect.selectByIndex(9);
        resue.takeScreenshot("Passenger Details");
    }

    public void proceedForPayment() throws IOException {
        WebElement paymentBtn = driver.findElement(By.xpath("//button[normalize-space()='Proceed To Payment']"));
        paymentBtn.click();
        resue.takeScreenshot("payment page");

}
}

