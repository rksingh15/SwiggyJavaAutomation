package page_Of_Food;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testingOfSwiggy {

	WebDriver driver;

	public void launchBrowser() {
//		driver = new ChromeDriver();
		driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");

	
		System.out.println("Swiggy website opened.");
	}

	public void clickSignButton() {
		WebElement loginBtn = driver.findElement(By.xpath("//a[@class='_5-C04']"));
		loginBtn.click();
		System.out.println("Clicked on Login button.");
	}

	public void clickLoginButton() {

		WebElement loginBtn = driver.findElement(By.xpath("//a[@class='lyOGZ']"));
		loginBtn.click();
		System.out.println("Clicked on Login button.");
	}

	public void enterPhoneNumber(String phone) {
		WebElement phoneInput = driver.findElement(By.xpath("//input[@type='tel']"));
		phoneInput.sendKeys(phone);
		System.out.println("Phone number entered: " + phone);
	}

	public void waitForOTP() {
		try {
			System.out.println(" Waiting 30 seconds...");
			Thread.sleep(30000); // 30 seconds pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyLogin() {
		try {
			WebElement profileIcon = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M40 20C40 ')]"));
			if (profileIcon.isDisplayed()) {
				System.out.println("Login successful!");
			}
		} catch (Exception e) {
			System.out.println("Login verification failed or OTP not entered.");
		}
	}

//--2-----------------------------------------------------------------------------
	
	public void validatePage() {
	    String title = driver.getTitle();
	    String url = driver.getCurrentUrl();

	    System.out.println("Page Title: " + title);
	    System.out.println("Current URL: " + url);

	    if (url.contains("swiggy.com")) {
	        System.out.println("Validation Successfull!");
	    } else {
	        System.out.println("Navigation Failed! Unexpected URL.");
	    }
	}
//3-----------------------------------------------------------------------------
	public void enterDeliveryLocation(String city) throws InterruptedException {
	    
	    WebElement locationBox = driver.findElement(By.xpath("//input[@id='location']"));
	    locationBox.click();
	    Thread.sleep(2000);

	   
	    locationBox.sendKeys(city);
	    System.out.println("Typed city name: " + city);
	    Thread.sleep(3000);

	   
	    WebElement firstSuggestion = driver.findElement(By.xpath("//span[contains(text(),'Bangalore Palace, Palace Cross Road, Vasanth Nagar')]"));
	    firstSuggestion.click();
	    System.out.println("Selected city first option from dropdown: " + city);

	  
	}
//--4-----------------------------------------------------
	public void searchRestaurant(String restaurantName) throws InterruptedException {
	    // Locate search bar
		
	    WebElement searchBar = driver.findElement(By.xpath("//div[@class='sc-aXZVg iGFOtL']"));
	    searchBar.click();
	    Thread.sleep(5000);
	    
	   
	    
	    WebElement searchres = driver.findElement(By.xpath("//input[@placeholder='Search for restaurants and food']"));
	    searchres.click();  
	   searchres.sendKeys(restaurantName);
	    System.out.println("Searching for restaurant: " + restaurantName);
	    Thread.sleep(2000);
	    
	    WebElement search2 = driver.findElement(By.xpath("//*[@data-testid='autosuggest-item'][1]"));
	    search2.click();
	    Thread.sleep(3000);

	   
	    WebElement firstRestaurant = driver.findElement(By.xpath("//a[contains(@aria-label,\"Restaurant name: Domino's Pizza,\")]"));
	    firstRestaurant.click();
	    System.out.println("Click on first restaurant result.");
	    
	     
	}
	
	//--5-----------------------------------------------------
	public void selectFoodAndViewCart() throws InterruptedException {
	    // Wait for menu load
	    Thread.sleep(3000);
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1400)");
		
		System.out.println("scrolled down");
		
	    

		

		 Thread.sleep(2000);
	    WebElement secondFoodAddBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
	    secondFoodAddBtn.click();
	    System.out.println("Second food item added to cart.");
	    Thread.sleep(2000);

	    
	    WebElement viewCartBtn = driver.findElement(By.xpath("//button[@aria-label='Step 1 out of 2. Double tap to continue to next step.']"));
	    viewCartBtn.click();
	    System.out.println("Continue. button clicked.");
	    Thread.sleep(2000);
	    
	    WebElement continueBtn = driver.findElement(By.xpath("//button[@data-cy='customize-footer-add-button']"));
	    continueBtn.click();
	    System.out.println("Continue button clicked.");
	    
	    Thread.sleep(3000);
	    WebElement CartBtn = driver.findElement(By.xpath("//button[@id='view-cart-btn']"));
	    CartBtn.click();
	    System.out.println("Add in Cart button clicked.");
	}
	//--6-----------------------------------------------------
	public void increaseItemQuantity() throws InterruptedException {
	    try {
	        // Wait for cart load
	        Thread.sleep(4000);

	        
	        WebElement plusBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
	        plusBtn.click();
	       

	        Thread.sleep(2000);

	      
	        WebElement quantity = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[2]"));
	        quantity.click();
	        System.out.println("Quantity increased by 1 (now 2).");
	       
	    } catch (Exception e) {
	        System.out.println(" Could not increase quantity. Element not found.");
	    }
	}
	
	//--7-----------------------------------------------------
	public void enterDeliveryAddress(String flat, String landmark) throws InterruptedException {
	    try {
	        Thread.sleep(4000);

	    
	        WebElement addNewAddressBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
	        addNewAddressBtn.click();
	        System.out.println("Clicked on Add New Address");
	        Thread.sleep(3000);

	       
	        WebElement flatInput = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1]"));
	        flatInput.sendKeys(flat);
	        System.out.println("Entered Flat/Door: " + flat);

	        Thread.sleep(1000);
	        WebElement landmarkInput = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[1]/input[1]"));
	        landmarkInput.sendKeys(landmark);
	        System.out.println("Entered Landmark: " + landmark);

	        Thread.sleep(1000);
	        WebElement homeBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]/div[3]/div[3]/div[1]"));
	        homeBtn.click();
	        System.out.println("Selected Address Button: Home");

	        Thread.sleep(1000);
	        WebElement saveAddressBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[4]/div/div"));
	        saveAddressBtn.click();
	        System.out.println("Clicked Save Address & Proceed");

	        Thread.sleep(4000);
	    } catch (Exception e) {
	        System.out.println("Could not enter delivery address. " + e.getMessage());
	    }
	}
	//--8-----------------------------------------------------
	public void proceedToPayment() throws InterruptedException {
	    try {
	       
	        WebElement PayBtn = driver.findElement(By.xpath("//button[text()='Proceed to Pay']"));
	        PayBtn.click();
	        System.out.println("Clicked Proceed to Pay button.");

	        Thread.sleep(5000);

	        
	        String url = driver.getCurrentUrl();
	        if (url.contains("checkout") || url.contains("payment")) {
	            System.out.println("Reached Payment Page successfully.");
	        } else {
	            System.out.println("Payment Page not reached.");
	        }
	    } catch (Exception e) {
	        System.out.println("Could not proceed to payment. " + e.getMessage());
	    }
	}




	public static void main(String[] args) throws InterruptedException {
		testingOfSwiggy swiggy = new testingOfSwiggy();

		swiggy.launchBrowser();

		Thread.sleep(10000); 
		swiggy.clickSignButton();

		swiggy.enterPhoneNumber("123456789");  // write own number
		Thread.sleep(2000);    
		swiggy.clickLoginButton();
		swiggy.waitForOTP(); // manual OTP entry
		swiggy.verifyLogin();
		//--2-----------------------------------------------------------------------------
		Thread.sleep(2000); 
		swiggy.validatePage();
		
		//3-----------------------------------------------------------------------------
		
		swiggy.enterDeliveryLocation("Bangalore");
		
		//--4-----------------------------------------------------
		  Thread.sleep(5000); 
		 swiggy.searchRestaurant("Domino's Pizza");
		 //--5-----------------------------------------------------
		 swiggy.selectFoodAndViewCart();
		//--6-----------------------------------------------------
		 swiggy.increaseItemQuantity();
		 //--7-----------------------------------------------------
		 swiggy.enterDeliveryAddress("006","Near Main Gate");
		 //--8-----------------------------------------------------
		 swiggy.proceedToPayment();
	}
}