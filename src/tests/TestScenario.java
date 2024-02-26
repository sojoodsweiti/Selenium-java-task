package tests;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.OrderConfirmationPage;
import Pages.ProductPage;

@Listeners
public class TestScenario extends reportClass{
    // Declare a WebDriver object
    private WebDriver driver;
    
    // Declare the page objects
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderConfirmationPage orderConfirmationPage;
    
    // Declare the URL of the application
    private String url = "https://magento.softwaretestingboard.com/";
    
    // Create a random number generator
    private Random random = new Random();
   
    

 // Create a method that runs before each test method
//    @BeforeTest
    @BeforeSuite
    public void setUp() {
        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
//        driver = new EdgeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to the home page of the application
        driver.get(url);
        
        // Initialize the page objects
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }
 
    
    // Create a test method for the scenario
    @Test
    public void testScenario() {
    	extentTest = report.createTest("Purchase a product", "To check shipping product scenario ");
    	extentTest.log(Status.INFO, "Test case started");
        // Search for "Shirt" product
        homePage.enterSearchKeyword("Shirt");
        
        // From the displayed items, click on random product
        homePage.selectRandomProduct();
        
        // From the Displayed Product Page, select the product options like size and color (If any options are there)
        productPage.selectRandomSize();
        productPage.selectRandomColor();
        
        // Click Add to Cart button
        productPage.clickAddToCartButton();
        
        // From the header, click on the shopping cart icon
       
        cartPage.clickCartIcon();
        cartPage.clickCartIcon();
        
        // From the displayed shopping cart modal, click on Proceed to Checkout button
        cartPage.clickProceedToCheckoutButton();
        
        // From the checkout page, fill in all the required fields. (The email value needs to be filled into a random way, every time new email being filled)
//        checkoutPage.enterEmail();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterStreet();
        checkoutPage.enterCity();
        checkoutPage.enterPostalCode();
        checkoutPage.selectCountry();
        checkoutPage.enterPhoneNumber();
        checkoutPage.enterEmail();
        // Complete the Checkout flow
        checkoutPage.clickNextButton();
        checkoutPage.clickPlaceOrderButton();
        
        // From the displayed order confirmation page, print the order number displayed at the page to your IDE console
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        orderConfirmationPage.getOrderNumber();
       
    }

 // Create a method that runs after each test method
//    @AfterTest
    @AfterSuite
    public void tearDown() {
        // Close the browser
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.quit();
    }
}
