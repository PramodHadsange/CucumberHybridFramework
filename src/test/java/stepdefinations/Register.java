package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	RegisterPage registerpage;
	CommonUtils commonutils;
	AccountSuccessPage accountsuccesspage;

	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickonMyAccount();
		registerpage = homepage.selectRegisterOption();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable)  {
	    
		Map<String,String>  dataMap = dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		commonutils = new CommonUtils();
		registerpage.enterEmail(commonutils.alphaNumeric());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
	   
		registerpage.selectPrivacyPolicy();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
	  
		accountsuccesspage = registerpage.clickContinuebutton();
	}

	@Then("User account get created successfully")
	public void user_account_get_created_successfully() {
	   
		Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectyesNewsLetterOption();
	}

	@Then("User should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() {
	   
		Assert.assertTrue(registerpage.getWarningmessageText().contains("Warning: E-Mail Address is already registered!") );
	}

	@When("User dont enters the details into below fields")
	public void user_dont_enters_the_details_into_below_fields() {
	  
	
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmail("");
		registerpage.enterTelephone("");
		registerpage.enterPassword("");
		registerpage.enterConfirmPassword("");
        
       

	}
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String,String>  dataMap = dataTable.asMap(String.class,String.class);

		 
			registerpage.enterFirstName(dataMap.get("firstName"));
			registerpage.enterLastName(dataMap.get("lastName"));
			registerpage.enterEmail(dataMap.get("email"));
			registerpage.enterTelephone(dataMap.get("telephone"));
			registerpage.enterPassword(dataMap.get("password"));
			registerpage.enterConfirmPassword(dataMap.get("password"));
	}

	@Then("User gets proper warning message for every mandatory fields")
	public void user_gets_proper_warning_message_for_every_mandatory_fields() {
	    
		Assert.assertTrue(registerpage.getPrivacypolicyWarning().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarningMessage() );
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarningMessage() );
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarningMessage() );
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarningMessage() );
		
	}

	}
