package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

	WebDriver driver;
	HomePage homepage;
	SearchResultsPage searchresultspage;
	
	@Given("User opens the Application")
	public void user_opens_the_application1() {
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
	 
		 homepage = new HomePage(driver);
		homepage.enterProductSearchBoxField(validProductText);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button1() {
		searchresultspage =   homepage.clickonSearchButton();
	}

	@Then("User should get valid product displayed in search  results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchresultspage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
	 
		 homepage = new HomePage(driver);

		 homepage.enterProductSearchBoxField(invalidProductText);

	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	
		Assert.assertEquals("There is no product that matches the search criteria.",searchresultspage.getMessageText());
	}

	

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	  
		 homepage = new HomePage(driver);
	}

	


}
