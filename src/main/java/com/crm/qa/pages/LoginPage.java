package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// we have to use Page Factory annotation @Find By annotation
	// or Object Repository
	@FindBy(name="email")
	WebElement email;
	// Below @FindBy annotation we can write @CacheLookup so that we can store our element to a cache memory
	// this will hit the cache memory to find the element instead of hitting the browser
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[3]/a")
	WebElement signUpBtn;
	
	@FindBy(className="onesignal-bell-svg")
	WebElement bellimage;
	
	// To initialize the driver to be able to access the elements as soon as the object of LoginPage has been made
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);//Initializing the Page Objects with this(current class objects)
	}
	
	// Defining the Actions here
	public String validateLoginPageTitle(){
		return driver.getTitle(); // verify the title of the page
	}
	
	public boolean validateBellImage(){
		return bellimage.isDisplayed(); // verify the bell image if displayed 
	}
	
	// login method
	public HomePage login(String en, String pwd) { // passing the username and password in this method
		 email.sendKeys(en); // no need to write WebElement username = driver.findElementByID("username").value();
		 password.sendKeys(pwd);
		 loginBtn.click(); // submit button pressed
		 // after clicking on login button, it is moving to home page. So Homepage is the return type of login function
		 return new HomePage(); // returning HomePage class object. Instead of void return type, the HomePage class is to be mentioned
	}
}
