package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Select_Browser {

	public static WebDriver driver;
	public static WebDriver Select(String Select_Browser_name, String URL)
	{
		if(Select_Browser_name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if (Select_Browser_name.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}
