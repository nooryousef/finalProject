package Saucedemo;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends Parameter {
	Parameter Swag=new Parameter();
	
@BeforeTest
public void SetUp() {
	
	driver.get(Url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));

	WebElement User=driver.findElement(By.id("user-name"));
	User.sendKeys(Swag.theUsername);
	
	WebElement Password=driver.findElement(By.id("password"));
	Password.sendKeys(Swag.Password);
	
	WebElement LogIn=driver.findElement(By.className("submit-button"));
    LogIn.click();

}



@Test(priority=1)
public void FilterItems() throws InterruptedException {
	Thread.sleep(1000);

	WebElement Sort=driver.findElement(By.cssSelector(".product_sort_container"));
	Sort.click();
	Thread.sleep(1000);

	List<WebElement> Filter=Sort.findElements(By.tagName("option"));
	Filter.get(3).click();
	
	Thread.sleep(1000);

}

@Test(priority=2)
public void AddToCart() {
	
	List<WebElement> Items=driver.findElements(By.className("inventory_list"));
	for(int i=0 ; i < Items.size() ; i++) {
		
		if(i==0) {
			
		WebElement Choose=driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
		Choose.click();
			
			
		}
		
		 if(i == Items.size()-1) {
			
			WebElement Choosetwo=driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
			Choosetwo.click();
		}
		
	} 
	
	
}


@Test(priority=3)
public void CheckOut() {
	
	WebElement Cart=driver.findElement(By.id("shopping_cart_container"));
	Cart.click();
	
	WebElement Checkout=driver.findElement(By.id("checkout"));
	Checkout.click();

	WebElement Firstname = driver.findElement(By.id("first-name"));
	WebElement Lastname = driver.findElement(By.id("last-name"));
	WebElement Post = driver.findElement(By.id("postal-code"));

	Firstname.sendKeys(Swag.fname);
	Lastname.sendKeys(Swag.lname);
	Post.sendKeys(Swag.postal);

	WebElement Continue = driver.findElement(By.id("continue"));
	Continue.click();

	WebElement finish = driver.findElement(By.id("finish"));
	finish.click();

// Assertion for Checkout
	WebElement complete = driver.findElement(By.className("complete-header"));
	String actual = complete.getText();

	Assert.assertEquals(actual.contains("Thank"), true);
	
	WebElement Ok=driver.findElement(By.className("pony_express"));
	Assert.assertEquals(Ok.isDisplayed(), true);

}

@AfterTest
public void Ending() {
}

}
