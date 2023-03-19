package Helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinksTrach {

	String l = "http://35.84.250.98/";
	WebDriver driver;
	@Test
	public void Links() throws MalformedURLException
	{
		
		driver = new FirefoxDriver();
		driver.get("http://35.84.250.98/");
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for(WebElement ele1 : ele)
		{
			URL url = new URL(l);
			try {
				HttpURLConnection conection = (HttpURLConnection) url.openConnection();
				conection.connect();
				/*if(conection.getResponseCode() == 200)
				{
					String Linkspage = ele1.getAttribute("href");
					//System.out.println("200 ok URL are = "+Linkspage);
					
					System.out.println("200 Response OK");
					System.out.println(Linkspage.length());
					
				}
				else*/ if(!(conection.getResponseCode() == 200))
				{
					String Linkspage = ele1.getAttribute("href");
					System.out.println("400 page not found broken links = "+Linkspage);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
}
