package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?zx=1773725344150&no_sw_cr=1");
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();

		
	
	}

}
