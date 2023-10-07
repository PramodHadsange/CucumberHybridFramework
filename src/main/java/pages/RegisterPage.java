package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastNamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following::div[1]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-lastname']/following::div[1]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-email']/following::div[1]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="//input[@id='input-telephone']/following::div[1]")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="//input[@id='input-password']/following::div[1]")
	private WebElement passwordWarningMessage;

	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNamefield, firstNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastNamefield, lastNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmail(String emailalphanumeric) {
		elementUtils.typeTextIntoElement(emailfield, emailalphanumeric,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephone(String telephoneNumber)
	{
		elementUtils.typeTextIntoElement(telephonefield, telephoneNumber,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordfield, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterConfirmPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(confirmpasswordfield, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void selectPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacyPolicyOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountSuccessPage clickContinuebutton()
	{
		elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void selectyesNewsLetterOption()
	{
		elementUtils.clickOnElement(yesNewsLetterOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningmessageText()
	{
		return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getPrivacypolicyWarning()
	{
		return elementUtils.getTextFromElement(privacyPolicyWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getFirstNameWarningMessage()
	{
		 return elementUtils.getTextFromElement(firstNameWarningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getLastNameWarningMessage()
	{
		return elementUtils.getTextFromElement(lastNameWarningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getEmailWarningMessage()
	{
		return elementUtils.getTextFromElement(emailWarningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneWarningMessage()
	{
		return elementUtils.getTextFromElement(telephoneWarningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getPasswordWarningMessage()
	{
		return elementUtils.getTextFromElement(passwordWarningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	

	
}
