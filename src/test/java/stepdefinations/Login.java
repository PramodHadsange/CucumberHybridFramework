package stepdefinations;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	 WebDriver driver;
	 LoginPage loginpage ;
	 CommonUtils commonutils;
	 AccountPage accountpage;
	

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		  HomePage homepage = new HomePage(driver);
		  homepage.clickonMyAccount();
		  loginpage= homepage.selectLoginoption();

	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validText) {
		
		loginpage.enterEmailAddress(validText);	}

	@When("^User enters valid password (.+) into password field$")
	public void user_enteres_valid_password_into_password_field(String passwordText) {
		
		loginpage.enterPassword(passwordText);
	}
/*	
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String validText) {
		
		loginpage.enterEmailAddress(validText);
	}

	@When("User enteres valid password {string} into password field")
	public void user_enteres_valid_password_into_password_field(String passwordText) {
		
		loginpage.enterPassword(passwordText);
	}
*/
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		accountpage = loginpage.clickonLoginbutton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidText) {
		
	    commonutils = new CommonUtils();
	    loginpage.enterEmailAddress(commonutils.getEmailWithTimeStamp());
    
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		
		loginpage.enterPassword(invalidPassword);
		

	}
	
	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
	    
	    loginpage.enterEmailAddress("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	   
	    loginpage.enterPassword("");
	}


	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
        Assert.assertTrue(loginpage.getwarningmessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	

}
