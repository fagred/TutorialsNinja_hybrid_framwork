package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath= "//input[@id = 'input-firstname']")
	private WebElement firstNameField;

	@FindBy(xpath= "//input[@id = 'input-lastname']")
    private WebElement lastNameField;

	@FindBy(id="input-email")
	private WebElement emailAddressField;

	@FindBy(id="input-telephone")
	private WebElement telephoneField;

	@FindBy(xpath="//input[@id = 'input-password']")
	private WebElement passwordField;

	@FindBy(xpath="//input[@name ='confirm']")
	private WebElement passwordConfirmField; 

	@FindBy(name="agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath="//input[@type ='submit']")
	private WebElement continueButton;

	@FindBy(xpath= "//div[@class ='alert alert-danger alert-dismissible']")
	private WebElement existingEmailWarning;

	@FindBy(xpath= "//div[@class ='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;

	@FindBy(xpath="//input[@name ='newsletter' and @value='1']")
    private WebElement yesNewsletterOption;

	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement passwordConfirmationWarning;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")
	private WebElement lastNameWarning;

	@FindBy(xpath="//input[@id='input-email']/following-sibling::div[@class='text-danger']")
	private WebElement emailWarning;

	@FindBy(xpath= "//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")
	private WebElement telephoneWarning;

	@FindBy(xpath="//input[@id='input-password']/following-sibling::div[@class='text-danger']")
	private WebElement passwordWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmailAdress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void enterPasswordConfirm(String PasswordText) {
		passwordConfirmField.sendKeys(PasswordText);
	}
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public String retrieveExistingEmailWarningText() {
	    String ExistingEmailWarningText = existingEmailWarning.getText();
	    return ExistingEmailWarningText;
}
	public String retrievePrivacyPolicyWarningText() {
		String PrivacyPolicyWarningText = privacyPolicyWarning.getText();
		return PrivacyPolicyWarningText;
	}
	public void selectYesNewsletterOption() {
		yesNewsletterOption.click();
}
	public String retrievePasswordConfirmationWarningText() {
		String passwordConfirmationWarningText = passwordConfirmationWarning.getText();
		return passwordConfirmationWarningText;
	}
	public String retrievePrivacyPolicyWarningMessage() {
		String privacyPolicyWarningTextMessage= privacyPolicyWarningMessage.getText();
		return privacyPolicyWarningTextMessage;
	}
	public String retrieveFirstNameWarningText() {
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	public String retrieveLastNameWarningText() {
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
}
	public String retrieveEmailWarningText() {
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	public String retrieveTelephoneWarning() {
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	public String retrievePasswordWarningText() {
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
}