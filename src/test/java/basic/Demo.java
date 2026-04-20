package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;

public class Demo {
	public static void main(String[] args) {

		System.out.println(LocalDate.now().plusDays(3));
		System.out.println(LocalDate.now());

		String s = "1,000";
		s= s.replaceAll(",","");
		int a = Integer.parseInt(s);
		System.out.println(a+100);

		int travellingDate = LocalDate.now().plusDays(4).getDayOfMonth();
		System.out.println(travellingDate);
	}

}
