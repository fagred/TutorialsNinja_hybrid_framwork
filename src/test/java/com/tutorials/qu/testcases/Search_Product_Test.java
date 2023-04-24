package com.tutorials.qu.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.base.TestBase;


public class Search_Product_Test extends TestBase { 
	
	public Search_Product_Test() throws Exception {
    	super();
    }
	
	public static WebDriver driver;	
	
	@BeforeMethod
	public void sutup() {
		
		
		
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserName"));	
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}
	
	@Test(priority=1)
	public void VerifysearchingwithanexistingProductName() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//div[@id= 'search']/descendent::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid product HP is not displayed in the search results");
       }
	
	@Test(priority=2)
	public void VerifysearchingwithanonexistingProductName() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.xpath("//div[@id= 'search']/descendent::button")).click();
		
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id= 'contente']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage,(dataProp.getProperty("NoProductTextInSearchResults")),"No product message in search results is not displayed");	
	    }
	
	
	@Test(priority=3)
	public void VerifysearchingwithoutprovidinganyProductName() {
		
		driver.findElement(By.xpath("//div[@id= 'search']/descendent::button")).click();
		
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id= 'contente']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage,(dataProp.getProperty("NoProductTextInSearchResults")),"No product message in search results is not displayed");
		
	}
}
