package SiteLocaotrs;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert.*;

public class Custmer_ratings {

	
	@FindBy(xpath = "//div[contains(@class,'_3sckoD')]")
	WebElement vsible_Rating;
	
	@FindBy(xpath = "//div[@class='_151IuQ']")
	WebElement cross;
	String pass_data = "";
	WebDriver driver;
	
	public Custmer_ratings(WebDriver I2Driver) 
	{
		this.driver = I2Driver;
	
	}
	
	
	public void Select_Rating(String ratingnumber) 
	{
		this.pass_data = ratingnumber;
		String xpathexpression = String.format("//div[contains(@class,'_3879cV') and contains(text(), '%s★ & above')]", ratingnumber);
		WebElement rT = driver.findElement(By.xpath(xpathexpression));		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		ExpectedCondition<Boolean> expectedcondition = driver -> rT.isDisplayed();
		wait.until(expectedcondition);
		
		System.out.println("Rating "+ratingnumber+" is given by the user");
		//wait.until(ExpectedConditions.elementToBeClickable(rT));
		
		rT.click();
		
		//========================================================================================================================
	}
	
	public void removeRating()
	{

		String xpathForverfy_visiblility = String.format("//div[contains(@class,'_3sckoD') and contains(text(),'%s★ & above')]", pass_data);
		WebElement verifyRatingisapplyied_Successfully = driver.findElement(By.xpath(xpathForverfy_visiblility));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		ExpectedCondition<Boolean> expectVerify = driver -> verifyRatingisapplyied_Successfully.isDisplayed();
		wait1.until(expectVerify);
		
		if(verifyRatingisapplyied_Successfully.isDisplayed())
		{
			cross.click();
			assertTrue(true);
		}else
		{
			System.out.println("check the rating something went wrong");
		
	}
	
}
}