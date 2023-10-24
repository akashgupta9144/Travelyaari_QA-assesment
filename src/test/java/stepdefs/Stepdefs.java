package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesObjects.Offers_page;
import pagesObjects.Search_Buses_Page;
import pagesObjects.TravelYaari_Hompage;

public class Stepdefs {
	WebDriver driver;
	Scenario scn;
	String URL="https://www.travelyaari.com/";
	WebDriverWait wait;
	Offers_page offers_page;
	TravelYaari_Hompage homepage;
	Search_Buses_Page search_Buses_page;
	
	@Before
		public void setup(Scenario scn) {
		this.scn=scn;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 20);
		
		offers_page=new Offers_page(driver,wait);
		homepage=new TravelYaari_Hompage(driver, wait);
		search_Buses_page= new Search_Buses_Page(driver, wait);
	}

	
		@Given("I am on the Travelyaari website homepage")
		public void i_am_on_the_travelyaari_website_homepage() {
		   driver.get(URL);
		   scn.log("Successfully ,I am on the Travelyaari website homepage");
		   }
		@When("I click on the Offers option")
		public void i_click_on_the_option() {
		  homepage.click_on_the_option();
		  scn.log("Successfully ,I click on the Offers option");
		}
		@Then("I am on the Offers tab")
		public void i_am_on_the_tab() {
		  offers_page.validate_i_am_on_the_Offer_tab();
		  scn.log("Successfully ,I am on the Offers page");
		
		}
		
		@When("I click on the {string} button")
		public void i_click_on_the_button(String btn ) {
			offers_page.click_on_the_BookNow_button(btn);
			scn.log("Successfully,I click the "+btn+" button");
		   
		}
		
		@When("I search for a bus from {string} to {string}")
	 	public void i_search_for_a_bus(String from_City, String to_City) throws InterruptedException{
			homepage.search_bus_for(from_City, to_City);
			scn.log("Successfully,i search  bus form "+from_City+" to " +to_City);
		}           
		
		@When("I select the date of journey {int}\\/{int}\\/{int}")
		public void i_select_the_date_of_journey(int day, int month, int year) throws InterruptedException {
			homepage.selecrt_the_date_of_journey(day, month, year);
			scn.log("Successfully,I select the date of journey");
			}
		
		@When("I click the {string} button")  
		public void i_click_the_button(String btn) throws InterruptedException { 
			homepage.click_the_Search_Bus_button(btn);
			scn.log("Successfully,I click the Search Bus button "); 
		   
		}
		@Then("I should see a list of buses operators with available seats")
		public void i_should_see_a_list_of_buses_operators_with_available_seats() {
		search_Buses_page.list_of_buses_operators_with_available_seats();
		scn.log("Successfully,see a list of all buses operators with available seats "); 
		}
		@Then("the list should include buses with more than {int} seats available")
		public void the_list_should_include_buses_with_more_than_seats_available(Integer int1) {
		    search_Buses_page.list_of_buses_operators_with_available_seats_more_then_4();
		    scn.log("Successfully,see a list of all buses operators with more then 4 seats available");
		}

		@After(order=2)
		public void failedScenarios_screenShot() {
			if(scn.isFailed()) {
				TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
				byte[] screenShot=takesScreenshot.getScreenshotAs(OutputType.BYTES);
				scn.attach(screenShot, "image/png","Failed Step Name:"+scn.getName());
			}
		}
		@After(order=1)
		public void terminate()  {
			
			driver.close();
		}


}
