package SiteLocaotrs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Check_for_Product {

	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'_30jeq3 _16Jk6d')]")
	WebElement Product_Price;
	
	public Check_for_Product(WebDriver I4driver)
	{
		this.driver = I4driver;
	}
	
	public void Select_on_Perticullar_Product(String Product_Name)
	{
		String Parent = driver.getWindowHandle();
		String xpathexpresionfor_Product = String.format("//div[contains(@class,'_4rR01T') and contains(text(),'%s')]", Product_Name);
		WebElement click_onProduct = driver.findElement(By.xpath(xpathexpresionfor_Product));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathexpresionfor_Product)));
		click_onProduct.click();
		
		// handle window==================================================================================================
		
		Set<String> L1 = driver.getWindowHandles();
		Iterator<String> L2 = L1.iterator();
		while(L2.hasNext())
		{
			String Child = L2.next();
			
			if(!Parent.equals(Child))
			{
				driver.switchTo().window(Child);
				System.out.println(driver.switchTo().window(Child).getTitle());
			}
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Price = Product_Price.getText();
		
		//System.out.println("Price text for the prodcut is ="+Price);
		
		int price = Integer.parseInt(Product_Price.getText().replaceAll("[^0-9]", ""));
		if(price < 15000 )
		{
			System.out.println(Product_Name+" = this product is under 15000 and the product prize is = "+price+" Rupees");
		}else if(price > 15000)
		{
			System.out.println(Product_Name+" = this  product is not under 15000");
		}
		driver.switchTo().window(Parent);
	}
	
	public void Select_for_another_Product(String productName)
	{
		String parent = driver.getWindowHandle();
		String xpathexpressionfor_SecondProduct = String.format("//div[contains(@class,'_4rR01T') and contains(text(),'%s')]", productName);
		WebElement product = driver.findElement(By.xpath(xpathexpressionfor_SecondProduct));
		product.click();
		
		Set<String> l3 = driver.getWindowHandles();
		Iterator<String> l4 = l3.iterator();
		
		while(l4.hasNext())
		{
			String child = l4.next();
			if(!parent.equals(child))
			{
				WebDriver win =  driver.switchTo().window(child);
				System.out.println("second product page tital is = "+win.getTitle());
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int price2 = Integer.parseInt(Product_Price.getText().replaceAll("[^0-9]", ""));
		
		if(price2 < 15000 )
		{
			System.out.println(productName+" = this product is under 15000 and the product prize is = "+price2+" Rupees");
		}else if(price2 > 15000)
		{
			System.out.println(productName+" = this  product is above  15000 and the price is = "+price2);
		}
		
	}
	
}
