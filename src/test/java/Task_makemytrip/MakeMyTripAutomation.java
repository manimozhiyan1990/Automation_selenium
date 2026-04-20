package Task_makemytrip;

import org.openqa.selenium.Keys;
import reusable.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class MakeMyTripAutomation {
    static WebDriver driver;
    static ReusableMethod reuse;

    public MakeMyTripAutomation(WebDriver driver) {
        this.driver = driver;
        this.reuse = new ReusableMethod(driver);
    }

    public void BusTicketbooking(String from, String to) throws InterruptedException {
        searchBus(from, to);
        filterBus();
    }

    public void searchBus(String from, String to) throws InterruptedException {
        clickpopUpBusTab();
        enterFromTo(from, to);
        enterDate();
    }

    public void filterBus() {

        appliedFilters();
    }

    private void clickpopUpBusTab() {
        try {
            WebElement logInPopup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
            reuse.waitforClickable(logInPopup);
            logInPopup.click();
        } catch (Exception e) {
            System.out.println("Login popup is not appear");
        }

        try {
            WebElement botpopup = driver.findElement(By.xpath("//div[@class='tp-dt-header']//img[@alt='minimize']"));
            reuse.waitvisiblityOfElement(botpopup);
            botpopup.click();
        } catch (Exception e) {
            System.out.println("Bot popup is not Present");
        }
        WebElement bustap = driver.findElement(By.xpath("//span[text()='Buses']/parent::a"));
        reuse.jsClick(bustap);
    }

    private void enterFromTo(String from, String to) throws InterruptedException {
        WebElement fromaddress = driver.findElement(By.id("fromCity"));
        reuse.waitvisiblityOfElement(fromaddress);
       fromaddress.click();
      Thread.sleep(2000);
        WebElement fromInput = driver.findElement(By.xpath("/input[@title='From']"));
        fromInput.sendKeys(from);
        WebElement fromCityOption = driver.findElement(By.xpath("//span[contains(text(),'Chennai, Tamil Nadu')]"));
        fromCityOption.click();
        WebElement toCity = driver.findElement(By.id("toCity"));
        reuse.jsClick(toCity);
        WebElement enterToCity = driver.findElement(By.xpath("//input[@placeholder='To']"));
        Thread.sleep(3000);
        enterToCity.sendKeys(to);
        enterToCity.sendKeys(Keys.ARROW_DOWN);
        enterToCity.sendKeys(Keys.ENTER);
    }

    private void enterDate() throws InterruptedException {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().plusDays(3));
        int travellingday = LocalDate.now().plusDays(3).getDayOfMonth();
        WebElement calander = driver.findElement(By.id("travelDate"));
        reuse.waitvisiblityOfElement(calander);
        WebElement day = driver.findElement(By.xpath("//div[text()='" + travellingday + "']"));
        day.click();

        WebElement Searchbutton = driver.findElement(By.xpath("//button[@id='search_button']"));
        Thread.sleep(3000);
        reuse.jsClick(Searchbutton);
        Thread.sleep(1000);


    }

    private void appliedFilters() {


    }



}
