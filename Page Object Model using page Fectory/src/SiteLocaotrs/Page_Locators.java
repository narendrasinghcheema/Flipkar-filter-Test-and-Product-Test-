package SiteLocaotrs;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Locators {

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement Cross_Buttone;
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement Search_for_Product;
	
	@FindBy(xpath = "//*[@class='_3uDYxP']/select")
	WebElement filter_DropDownFor_Price;
	
	@FindBy(xpath = "//*[@class='_30jeq3 _1_WHN1']")
	WebElement price_for_the_Product;
	
	
	WebDriver driver;
	
	//==============================================================================================
	public Page_Locators(WebDriver Idriver)
	{
		this.driver = Idriver;
	}
	//===============================================================================================
	
	public void SelectCross_forclosePopUp()
	{
		Cross_Buttone.click();
	}
	
	public void Searchfor_AnyProduct(String Product_Name)
	{
		Search_for_Product.sendKeys(Product_Name);
		Search_for_Product.sendKeys(Keys.ENTER);
	}
	public void SelectPrice_Accordingly_for_apply_Filter(String number)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_30jeq3 _1_WHN1']")));
		
		Select select = new Select(filter_DropDownFor_Price);
		select.selectByValue(number);
	}
	
	public void Vrify_Filter_Results()
	{
		
	    boolean allpriceunder_10000 = true;
	    
	    for(WebElement product_Price : driver.findElements(By.xpath("//*[@class='_30jeq3 _1_WHN1']")))
	    {
	    	int price = Integer.parseInt(product_Price.getText().replaceAll("[^0-9]", ""));
	    	if(price < 10000)
	    	{
	    		allpriceunder_10000 = true;
	    		List<String> productin_10000 = new ArrayList<>();
	    	
	    		for(WebElement ele : driver.findElements(By.xpath("//div[@class='_4rR01T']")))
	    		{
	    			productin_10000.add(ele.getText());
	    		}
	    		System.out.println(productin_10000);
	    		 System.out.println("Products not under 10000:");
	    		 break;
	    		
	    	}
	    	else if(price > 10000)
	    	{
	    		allpriceunder_10000 = false;
	    		List<String> productnotin_10000 = new ArrayList<>();
		    	
		    		for(WebElement ele : driver.findElements(By.xpath("//div[@class='_4rR01T']")))
		    		{
		    			productnotin_10000.add(ele.getText());
		    		}
		    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    		System.out.println(productnotin_10000);
		    		 System.out.println("Product under 10000:");
	    		break;
	    	}
	    }
	    
	}
}
