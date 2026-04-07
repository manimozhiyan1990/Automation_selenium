package district;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.io.FileHandler;

public class ReusableMethod {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    JavascriptExecutor js;

    public ReusableMethod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void jsClick(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public WebElement waitForVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void scrollByPixel(int x, int y) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
    }

    public void takeScreenshot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("C:\\Users\\user\\IdeaProjects\\SeleniumProject\\target\\Screenshot\\district\\" + imageName + ".png");
        FileHandler.copy(src, dest);
    }
    public void waitForManualOTP() {
        System.out.println("👉 Enter OTP manually and press ENTER...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}