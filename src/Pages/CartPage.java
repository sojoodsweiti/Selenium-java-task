package Pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	 // Create a random number generator
   private Random random = new Random();
// Create a constructor that takes a WebDriver object as an argument
   public CartPage(WebDriver driver) {
       this.driver = driver;
   }
   public void clickCartIcon() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
       try {
    	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("message-success")));
    	   	driver.findElement(By.className("showcart")).click();
       }catch (TimeoutException e) {
           System.out.println("TimeoutException: Element not interactable within 30 seconds.");
       } catch (ElementNotInteractableException e) {
           System.out.println("ElementNotInteractableException: Element not interactable.");
       }
	}
	
   public void clickProceedToCheckoutButton() {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.findElement(By.className("showcart")).click();
	   driver.findElement(By.cssSelector(".action.primary.checkout")).click();
	}
}
