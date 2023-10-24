package pagesObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.Messages.ParseError;

public class Search_Buses_Page { 
	WebDriver  driver;
	WebDriverWait wait;
	int count=0;
	int total_Buses=0;
	String Result;
	By buses_List=By.xpath("//div[@class='srch-card']//div[@class='label-blk']//div[@class='dark-txt']");
	By availibilty=By.xpath("//div[@class='st-offr-blk']");
	public Search_Buses_Page(WebDriver  driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		}
	
	public void list_of_buses_operators_with_available_seats() {
		List<WebElement> buses_elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buses_List));
		System.out.println("list of buses operators with available seats:");
		for (int i = 0; i <buses_elements.size(); i++) {
			total_Buses++;
			System.out.println(buses_elements.get(i).getText());
		}
		System.out.println("Total buses on this route:"+total_Buses);
		
	}  
	
	public void list_of_buses_operators_with_available_seats_more_then_4() {
		List<WebElement> buses_elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buses_List));
		List<WebElement>seat_availiblity=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availibilty));
		
		System.out.println("list of buses operators with available more then 4 seats:");
		for (int i = 0; i <buses_elements.size(); i++) {
			String temp=seat_availiblity.get(i).getText();
			 StringBuilder result = new StringBuilder();
		        boolean flag = false;

		        for (char c : temp.toCharArray()) { 
		            if (Character.isDigit(c)) {
		                Result=String.valueOf(result.append(c));
		                flag = true;
		            } else if (flag) {
		                break; 
		            }
		        }
		        int number_Of_seats=Integer.parseInt(Result);
		        System.out.println(number_Of_seats);
			if(number_Of_seats>4) {
				count++;
			System.out.println(buses_elements.get(i).getText());
			}}
		System.out.println("Number og Buses have more then 4 seats:"+count);
		}
		
	}

