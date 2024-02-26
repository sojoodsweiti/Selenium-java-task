package Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderConfirmationPage {
	private WebDriver driver;
	//Create a constructor that takes a WebDriver object as an argument
	public OrderConfirmationPage(WebDriver driver) {
     this.driver = driver;
	}
	public void getOrderNumber() {
		WebElement orderNumber =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/p[1]/span"));
		System.out.println("Order number: " + orderNumber.getText());
		// Verify that the order number is not null or empty 
//		Assert.assertNotNull(orderNumber.getText());
//	    Assert.assertFalse(false, orderNumber.getText());
	}
}
