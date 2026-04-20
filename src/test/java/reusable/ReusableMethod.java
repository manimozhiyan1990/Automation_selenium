package reusable;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    // =============================wait method===============================
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public WebElement waitforClickable(WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitvisiblityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public WebElement waitvisiblityOfLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
//=======================javascript==================================
    public void jsScroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollByPixel(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
    }
//=====================screen shot====================================
    public void takeScreenshot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("C:\\Users\\user\\Documents\\GitHub\\Automation_selenium\\SeleniumProject\\target\\Screenshot\\Yatra\\" + imageName + ".png");
        FileHandler.copy(src, dest);
    }

    public void waitForManualOTP() {
        System.out.println(" Enter OTP manually and press ENTER...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    // Action method=========================

    public void mouseHover(WebElement element) {
        action.moveToElement(element).perform();

    }

    public void mouseHoverClick(WebElement element) {
        action.moveToElement(element).click().perform();
    }

    public void doubleClick(WebElement element) {
        action.doubleClick(element).click().perform();
    }

    public void rightClick(WebElement element) {
        action.contextClick(element).perform();
    }
    public void delayclick(WebElement element){
        action.moveToElement(element).pause(Duration.ofSeconds(2000)).click().perform();
    }


    //===================Drop Down======================================

    public void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
}