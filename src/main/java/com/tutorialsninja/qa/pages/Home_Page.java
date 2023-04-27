package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;

	//objects
	@FindBy(xpath="//span[text()= 'My Account']")
    private WebElement myAccountDropMenu;

	@FindBy(linkText="Login")
	private WebElement loginOption;

	@FindBy(linkText="Register")
	private WebElement RegisterOption;

	@FindBy(name="search")
	private WebElement searchBoxField; 

	@FindBy(xpath="//button[@class ='btn btn-default btn-lg']")
	private WebElement searchButton;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver,HomePage.class);
		PageFactory.initElements(driver,this);
	}

	//Actions

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void enterProductNameInSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}
	public void clickOnMyAccount() {
			myAccountDropMenu.click();

		}
	public void selectLoginOption() {
		loginOption.click();
	}
	public void selectRegisterOption() {
		RegisterOption.click();
	}



	}