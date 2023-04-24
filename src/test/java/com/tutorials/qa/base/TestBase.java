package com.tutorials.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.base.Utilities;

public  class TestBase  {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public Properties dataProp;
	
	public TestBase() throws Exception {
	   prop = new Properties();
	   ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
	   prop.load(ip);
	   dataProp = new  Properties();
	   File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
	   
	   FileInputStream datafis = new FileInputStream(dataPropFile);
	   dataProp.load(datafis);
	   
	}
	   
	
	public WebDriver InitializeBrowserAndOpenApplication(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicit_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
		driver.get("https://tutorialsninja.com/demo/");
		return driver;
		
	}

}
