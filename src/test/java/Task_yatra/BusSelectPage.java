package Task_yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.ReusableMethod;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class BusSelectPage {
    static WebDriver driver;
    static ReusableMethod resue;

    public BusSelectPage(WebDriver driver) {
        this.driver = driver;
        this.resue = new ReusableMethod(driver);
    }

    public void ChooseBusType(String bustype) throws IOException {

        WebElement filters = driver.findElement(By.xpath("//span[text()='Filters']"));
        filters.click();
        List<WebElement> busTypes = driver.findElements(By.xpath("//div[text()='Bus Type:']/following-sibling::label"));

        for (WebElement bus : busTypes) {
            String busOption = bus.getText().toLowerCase();
            System.out.println(busOption);

            if (busOption.equals(bustype.toLowerCase())) {
                WebElement busSelect = driver.findElement(By.xpath("//span[text()='" + bustype + "']"));
                resue.jsClick(busSelect);
                break;
            }

        }
        resue.takeScreenshot("Bus type");
        driver.findElement(By.xpath("//button[@aria-label='Apply Filters']")).click();
    }

    public void getLowestfareBus() throws IOException {

        int lowestBusFare = Integer.MAX_VALUE;
        String lowestBusName ="";
        WebElement lowestBus = null;

        List<WebElement> allBusList = driver.findElements(By.xpath("//div[contains(@class,'srp-touple')]"));

        for (WebElement bus : allBusList) {

            String priceText = bus.findElement(By.xpath(".//div[contains(@class,'fs24')]/span[2]")).getText();

            priceText = priceText.replaceAll(",", "");
            if (priceText.isEmpty())
             continue;
            int busFare = Integer.parseInt(priceText);

            String busName = bus.findElement(By.xpath(".//div[contains(@class,'op-name')]")).getText();

            if(busFare<lowestBusFare){
                lowestBusFare = busFare;
                lowestBusName=busName;
                lowestBus =bus;
            }
        }
        resue.takeScreenshot("Lowest fare bus");
        System.out.println("LOWEST BUS: " + lowestBusName + " →  Rs ₹ " + lowestBusFare);

//        WebElement selectSeatBtn = driver.findElement(By.xpath("//div[text()='Select Seat']"));
//        resue.jsClick(selectSeatBtn);
    }


}
