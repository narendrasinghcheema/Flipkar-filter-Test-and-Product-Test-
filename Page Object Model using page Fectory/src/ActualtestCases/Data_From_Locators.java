package ActualtestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helper.Select_Browser;
import SiteLocaotrs.Check_for_Product;
import SiteLocaotrs.Custmer_ratings;
import SiteLocaotrs.FilterBrand;
import SiteLocaotrs.Page_Locators;


public class Data_From_Locators {

	
	Check_for_Product obj4;
	Page_Locators obj;
	Custmer_ratings obj3;
	FilterBrand obj2;
	WebDriver driver;
	

	@Test(priority = 0)
	public void test_FilterBy_Money()
	{
		driver = Select_Browser.Select("firefox", "https://www.flipkart.com/");
		obj = PageFactory.initElements(driver, Page_Locators.class);
		obj.SelectCross_forclosePopUp();
		obj.Searchfor_AnyProduct("android Mobile");
		obj.SelectPrice_Accordingly_for_apply_Filter("10000");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj.Vrify_Filter_Results();
		
	}
	
	
	@Test(priority = 1)
	public void Test_FilterBy_Searching_invalid_Brands()
	
	{
		obj2  =  PageFactory.initElements(driver, FilterBrand.class);
		obj.SelectPrice_Accordingly_for_apply_Filter("10000");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Search_any_invalid_BrandFilter("djkwn");
	}
	
	
	@Test(priority = 2)
	public void Test_FilterBy_Searching_valid_Brands()
	
	{
		obj2  =  PageFactory.initElements(driver, FilterBrand.class);
		obj.SelectPrice_Accordingly_for_apply_Filter("15000");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Search_any_validBrandFilter("Samsung");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(priority = 3)
	public void testCUSTOMER_RATINGS()
	
	{
		obj3 = PageFactory.initElements(driver, Custmer_ratings.class);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		obj3.Select_Rating("4"); 
	}
	
	@Test(priority = 4)
	public void RemoveRating()
	
	{
		obj3 = PageFactory.initElements(driver, Custmer_ratings.class);
		obj3.removeRating();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test(priority = 5)
	public void forstProductTest()
	{
		obj4 = PageFactory.initElements(driver, Check_for_Product.class);
		obj4.Select_on_Perticullar_Product("SAMSUNG Galaxy F13 (Waterfall Blue, 64 GB)");	
	}
	
	@Test(priority = 6)
	public void Secondnd_ProductVerify_Price()
	{
		obj4.Select_for_another_Product("SAMSUNG Galaxy F13 (Waterfall Blue, 128 GB)");
		
	}
}

