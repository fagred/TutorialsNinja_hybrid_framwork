package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	@FindBy(linkText = "iMac")
	private WebElement existingIMacProduct;

	@FindBy(xpath="//div[@id ='content']/h2/following-sibling::p")
	private WebElement noProductMessage;

	@FindBy(xpath="//div[@id='content']//h2")
	private WebElement productsMeetingTheSearchCriteria;



	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retriveProductsMeetingTheSearchCriteriaText() {
	   String productsMeetingTheSearchcriteriaText=productsMeetingTheSearchCriteria.getText();
	 return productsMeetingTheSearchcriteriaText;
	}
	public String retrieveNoProductMessageText() {
		String noProductMessageText =noProductMessage.getText();
		return noProductMessageText;

	}
	public boolean displayTheStatusOfIMacProduct() {
		boolean displayStatusOfProduct =existingIMacProduct.isDisplayed();
		return displayStatusOfProduct;	
	}
}