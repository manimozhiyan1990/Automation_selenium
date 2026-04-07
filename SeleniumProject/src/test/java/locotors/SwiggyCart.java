package locotors;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SwiggyCart {

    static WebDriver driver;

    public static void takeScreenShot(String ImageName) throws IOException {
        TakesScreenshot image = (TakesScreenshot) driver;
        File screenshotAs = image.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\Swiggy\\homepage\\screenshot\\"+ImageName+".jpg");
        Files.copy(screenshotAs, path);

    }

    public static void elementScreenShot(WebElement e,String Image) throws IOException {
        File sc = e.getScreenshotAs(OutputType.FILE);
        File path1 = new File("C:\\Users\\user\\eclipse-workspace\\SeleniumProject\\target\\Screenshot\\Swiggy\\elements\\"+Image+".png");
        Files.copy(sc, path1);
    }

    public static void clickDish(String dishName) throws IOException, InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.swiggy.com/");


        WebElement element = driver.findElement(By.xpath("//div[text()='Search for restaurant, item or more']"));
        element.click();
        List<WebElement> items = driver.findElements(By.xpath("//button[@data-testid='image-info-ripple']"));
        int TotalDishDiplayed = items.size();
        System.out.println(TotalDishDiplayed);
        takeScreenShot("image2");

        WebElement element1 = driver.findElement(By.xpath("//div[@data-testid='grid-container']"));
        WebElement element2 = driver.findElement(By.xpath("//div[@class='global-nav']"));

        elementScreenShot(element2,"Header");

        switch (dishName.toLowerCase()) {
            case "Pizzas":
                items.get(0).click();
                break;

            case "Rolls":
                items.get(1).click();
                break;

            case "tea":
                items.get(2).click();
                break;

            case "burger":
                items.get(3).click();
                break;

            case "chinese":
                items.get(4).click();
                break;

            case "cake":
                items.get(5).click();
                break;

            case "dessert":
                items.get(6).click();
                break;

            case "north indian":
                items.get(7).click();
                break;

            case "south indian":
                items.get(9).click();
                break;

            case "sandwich":
                items.get(9).click();
                break;

            case "ice cream":
                items.get(10).click();
                break;

            case "indian snacks":
                items.get(11).click();
                break;

            default:
                System.out.println("Invalid dish name: " + dishName);
        }
        Thread.sleep(2000);
        takeScreenShot("final");
        Thread.sleep(3000);
        driver.quit();
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        clickDish("ice cream");


    }

}




