package com.tutorials.qu.testcases;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorials.qa.base.TestBase;
import com.tutorialsninja.qa.base.Utilities;
import com.tutorialsninja.qa.pages.Home_Page;
import com.tutorialsninja.qa.pages.LoginPage;


    public class LoginTest  extends TestBase{
    	
    
    public LoginTest() throws Exception {
    	super();
    }
    	
    
	public static WebDriver driver;	
	
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		
	
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		Home_Page home_Page = new Home_Page(driver);
		home_Page.clickOnMyAccount();
		home_Page.selectLoginOption();
		
	}
	@AfterMethod
	public void tearDown () {
		
	driver.quit();
	
	}
	
	@Test(priority=1,dataProvider="validSredentialsSupplier" )
     public void VerifyloggingintothApplicationusingvalidcredentials(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		 
 
       driver.findElement(By.xpath("//input[@value='Login']")).click();
       softassert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
       softassert.assertAll();
       
	   }
	@DataProvider(name="validSredentialsSupplier") 
	public Object [] [] supplyTestData() {
		Object [][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	  }
	
	
	@Test(priority=2)
	 public void VerifylogingintotheApplicationusinginvalidcredentials() {
		
       driver.findElement(By.id("input-email")).sendKeys("faridaagred07123 + generateTimeStamp()"
       		+ "@gmail.com");
       driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
       driver.findElement(By.xpath("//input[@value='Login']")).click();
       
       String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
       String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
       
       softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
       softassert.assertAll();
       
       
	   }
	public String generateTimeStamp() {
	Date date = new Date();
	return date.toString().replace(" ", "_").replace(":","_");
	}
	
	@Test(priority=3)
	public void VerifyloggingintotheApplicationusinginvalidemailaddressandvalidPassword() {	
		
          driver.findElement(By.id("input-email")).sendKeys("faridaagred07123 + generateTimeStamp()"
          		+ "@gmail.com");
          driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
          String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
          
          softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
          softassert.assertAll();
          
	      }
	  @Test(priority=4)
 	   public void VerifylogintotheApplicationusingvalidemailddressandinvalidPassword() {
		
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
          String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
          
          softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
          softassert.assertAll();
          
	     }
	    @Test(priority=5)
	    public void VerifyloginintotheApplicationwithoutprovidinganycredentials() {
	    	
	       
	        driver.findElement(By.xpath("//input[@value='Login']")).click();
	          
	          String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
	          String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
	          
	          softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
	          softassert.assertAll();
	         
		     }	
	     }
    
    