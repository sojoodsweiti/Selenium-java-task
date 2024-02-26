package Pages;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	 // Create a random number generator
    private Random random = new Random();
 // Create a constructor that takes a WebDriver object as an argument
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
	public void selectRandomSize() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> productSize = driver.findElements(By.cssSelector(".swatch-option.text"));
		int randomIndex = Math.abs(random.nextInt(productSize.size()));
		System.out.println(randomIndex);
		System.out.println(randomIndex);
		productSize.get(randomIndex).click();
	
	}
	
	public void selectRandomColor() {
		List<WebElement> productColor = driver.findElements(By.cssSelector(".swatch-option.color"));
		int randomIndex = random.nextInt(productColor.size());
		productColor.get(randomIndex).click();
	}
	
	public void clickAddToCartButton() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}
	
//	public void clickCartIcon() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//        try {
//	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("showcart")));
//	        element.click();
//        }catch (TimeoutException e) {
//            System.out.println("TimeoutException: Element not interactable within 30 seconds.");
//        } catch (ElementNotInteractableException e) {
//            System.out.println("ElementNotInteractableException: Element not interactable.");
//        }
//	}
	
	
}
