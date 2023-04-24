package com.tutorials.qu.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.base.TestBase;
import com.tutorialsninja.qa.base.Utilities;


public class RegisterTest extends TestBase {
	
	public RegisterTest() throws Exception {
    	super();
    }
	
	public static WebDriver driver;	
	
	@BeforeMethod
	
public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserName"));
        driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
        driver.findElement(By.linkText("Register")).click();	
	
	}

	@AfterMethod
	public void tearDown() {
		
	driver.quit();
	}
	
	@Test(priority=1)
     public void VerifyRegisteringanAccountbyprovidingonlytheMandatoryfields() {
		
        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id = 'Content']/h1")).getText();
        Assert.assertEquals(actualSuccessHeading,prop.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
        
	    }
	
        @Test(priority=2)
	   public void VerifyRegisteringanAccountbyprovidingallthefields() {
        	
        	driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
            driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
            driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
            driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
            driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("browserName"));
            driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("browserName"));
            driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
            String actualSuccessHeading = driver.findElement(By.xpath("//div[@id = 'Content']/h1")).getText();
            Assert.assertEquals(actualSuccessHeading,prop.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
            
            }
	    @Test(priority=3)
        public void VerifyRegisteringanAccountbyprovidingtheexistingaccount() {
	    	
	    	driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
            driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
            driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
            driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
            driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
            driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
            driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
            
            String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible']")).getText();
            Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regaring duplicate");
            
	        }
	    
	    @Test(priority=4)
	    public void VerifyRegistereingAccountWithoutFillingAnyDetails() {
	    	
            driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
            
            String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible']")).getText();
            Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning message is not displayed");
            
            String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
            Assert.assertEquals(actualFirstNameWarning, (dataProp.getProperty("firstNameWarning")),"First Name Message Warning is not displayed");
            
            String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-laststname']/following-sibling::div")).getText();
            Assert.assertEquals(actualLastNameWarning, (dataProp.getProperty("lastNameWarning")),"Last Name Message Warning is not displayed");
            
            String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
            Assert.assertEquals(actualEmailWarning,(dataProp.getProperty("emailWarning")) ,"Email Message Warning is not displayed");
            
            String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
            Assert.assertEquals(actualTelephoneWarning, (dataProp.getProperty("telephoneWarning")),"Telephone Message Warning is not displayed");
            
            String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
            Assert.assertEquals(actualPasswordWarning, (dataProp.getProperty("PasswordWarning")),"Password Message Warning is not displayed");
            
        }
	    
}