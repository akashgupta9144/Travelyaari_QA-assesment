package pagesObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class Offers_page {
	WebDriver driver;
	WebDriverWait wait;
	By bookNow_Btn=By.xpath("//div[text()='BOOK NOW']");
	
	public Offers_page(WebDriver driver,WebDriverWait wait) {
	this.driver=driver;
	this.wait=wait;
	
	}
	
	public void validate_i_am_on_the_Offer_tab() {
		String expected="https://www.travelyaari.com/offers";
		Assert.assertEquals(expected, driver.getCurrentUrl());
	}
	
	public void click_on_the_BookNow_button(String btn) {
		String expected=btn;
		WebElement bookNow_element=wait.until(ExpectedConditions.elementToBeClickable(bookNow_Btn));
		if(expected.equalsIgnoreCase(bookNow_element.getText())) {
			bookNow_element.click();
			}
		
		}
	}
