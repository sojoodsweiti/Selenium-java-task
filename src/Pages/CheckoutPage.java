package Pages;

import java.time.Duration;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class CheckoutPage {
	private WebDriver driver;
	 // Create a random number generator
	private Random random = new Random();
	//Create a constructor that takes a WebDriver object as an argument
	public CheckoutPage(WebDriver driver) {
      this.driver = driver;
	}
	public void enterEmail() {
		Random random = new Random();
		int randomNumber = random.nextInt(100); // Generate a random number
        String email = "sojoodsweiti"+ randomNumber+ "@gmail.com";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        try {
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer-email")));
	        element.clear();
	        element.sendKeys(email); 
        }catch (TimeoutException e) {
            System.out.println("TimeoutException: Element not interactable within 30 seconds.");
        } catch (ElementNotInteractableException e) {
            System.out.println("ElementNotInteractableException: Element not interactable.");
        }

	} 
	
	public void enterFirstName() {
		driver.findElement(By.name("firstname")).sendKeys("sojood");
	}
	
	public void enterLastName() {
		driver.findElement(By.name("lastname")).sendKeys("sweiti");
	}
	
	public void enterStreet() {
		driver.findElement(By.name("street[0]")).sendKeys("Hebron-15");
	}
	
	public void enterCity() {
		driver.findElement(By.name("city")).sendKeys("Hebron");
	}
	
	public void enterPostalCode() {
		driver.findElement(By.name("postcode")).sendKeys("12345-6789");
	}
	
	public void selectCountry() {
		driver.findElement(By.name("country_id")).click();
		driver.findElement(By.cssSelector("[data-title='Palestinian Territories']")).click();
	}
	
	public void enterPhoneNumber() {
		driver.findElement(By.name("telephone")).sendKeys("0594215768");
	}
	
	public void clickNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("continue")));
		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")).click();
		element.click();
//		driver.findElement(By.className("continue")).click();
	}
	public void clickPlaceOrderButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("billing-address-same-as-shipping")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"))).click();
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout")));
	}
}
