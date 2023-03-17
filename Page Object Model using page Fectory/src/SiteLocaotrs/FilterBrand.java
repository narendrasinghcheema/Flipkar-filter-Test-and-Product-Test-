package SiteLocaotrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterBrand {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@class='_34uFYj']")
	WebElement searchfor_anyBrand;
	
	@FindBy(xpath = "//div[@class='QvtND5 _2w_U27']//span[text()='84 MORE']")
	WebElement ValueVisible;
	
	@FindBy(xpath = "//div[@class='_24_Dny']")
	WebElement DropDown_Search_Result;
	
	
	    //==============================================================================================
		public FilterBrand(WebDriver Iadriver)
		{
			this.driver = Iadriver;
		}
		//===============================================================================================
	
	
	
	public void Search_any_invalid_BrandFilter(String invalid_BrandName)
	{
		searchfor_anyBrand.sendKeys(invalid_BrandName);
		
		searchfor_anyBrand.clear();
	}
	
	public void Search_any_validBrandFilter(String Valid_BrandName)
	{
		searchfor_anyBrand.sendKeys(Valid_BrandName);
		String textValue = Valid_BrandName;
		String xpathExpression = String.format("//div[text()='%s']", textValue);
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		
		
		if(element.isDisplayed())
		{
			System.out.println("Brand Name by User is "+element.getText()+" So the result which user search for is wright");
			DropDown_Search_Result.click();
		} else {
			System.out.println("Search is wrong");
		}	
}
}
