package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@id=\"input-password\"]//following::input")
	private WebElement Loginbutton;
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail ')]")
	private WebElement warningmessage;
	
	public void enterEmailAddress(String validText)
	{
		elementUtils.typeTextIntoElement(emailfield, validText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordfield, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage clickonLoginbutton()
	{
		elementUtils.clickOnElement(Loginbutton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	

	public String getwarningmessage() {
		
		return elementUtils.getTextFromElement(warningmessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
}