package pagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelYaari_Hompage {
	WebDriver driver;
	WebDriverWait wait;
	By offer_option = By.xpath("//div[@class='left']//a[text()='Offers']");
	By source_city = By.id("from-city");
	By destination_city = By.id("to-city");
	By journey_date = By.id("from-date");
	By search_Bus = By.xpath("//button[text()='Search Bus']");
	
	public TravelYaari_Hompage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public void click_on_the_option() {

		WebElement click_option = wait.until(ExpectedConditions.elementToBeClickable(offer_option));
		click_option.click();
	}

	public void search_bus_for(String from_City, String to_City) throws InterruptedException {

		WebElement source_city_Element = wait.until(ExpectedConditions.visibilityOfElementLocated(source_city));
		source_city_Element.sendKeys(from_City);
		Thread.sleep(2000);
		source_city_Element.sendKeys(Keys.ENTER);

		WebElement destination_city_Element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(destination_city));
		destination_city_Element.sendKeys(to_City);
		Thread.sleep(2000);
		destination_city_Element.sendKeys(Keys.ENTER);

	}

	public void selecrt_the_date_of_journey(int day, int month, int year) throws InterruptedException {
		WebElement calender=wait.until(ExpectedConditions.elementToBeClickable(journey_date));
		calender.click();
		int travellMonth=month-1;
		By DOJ=By.xpath("//div[@class='pika-label']/ancestor::div[@class='pika-lendar']/table//td//button[@data-pika-year='"+year+"' and @data-pika-month='"+travellMonth+"' and @data-pika-day='"+day+"' ]");
		WebElement travel_date=wait.until(ExpectedConditions.elementToBeClickable(DOJ));
		travel_date.click();
	
		
		}
		
	public void click_the_Search_Bus_button(String btn) throws InterruptedException {
		
		WebElement search_btn_element = wait.until(ExpectedConditions.elementToBeClickable(search_Bus));
		if (btn.equalsIgnoreCase(search_btn_element.getText())) {
			search_btn_element.click();
			String title = driver.getTitle();
			System.out.println(title);
		}
	}
}