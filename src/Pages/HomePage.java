package Pages;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    // Declare a WebDriver object
    private WebDriver driver;
    
    // Create a random number generator
    private Random random = new Random();
    
    // Create a constructor that takes a WebDriver object as an argument
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Create a method that enters a keyword in the search box
    public void enterSearchKeyword(String keyword) {
        driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);
    }
    
    public void selectRandomProduct() {
    	// From the displayed items, click on random product
//        List<WebElement> products = driver.findElements(By.className("product-item-link"));
        List<WebElement> products = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li"));
        int randomIndex = random.nextInt(products.size());
        products.get(randomIndex).click();
	}
    
    

}
