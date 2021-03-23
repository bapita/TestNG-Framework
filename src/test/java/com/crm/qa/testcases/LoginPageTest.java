package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser
	LoginPage loginpage;
	HomePage homepage;

	// first task - defining the constructor of this class
	public LoginPageTest() {
		super(); // super keyword would call the constructor of the base class to get the
					// properties
	}

	@BeforeMethod
	public void setUp() {
		initialization(); // calling the base class method to initialize the driver
		// create object of login page class, so that we can get the page objects of
		// that class initialized and we can access the member methods and variables
		loginpage = new LoginPage();
	}

	////////////// writing the test cases below//////////
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		// to confirm that the test case passes or fails
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority = 2)
	public void bellImageTest() {
		boolean flag = loginpage.validateBellImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		// Since this would return HomePage class object. So, need a variable /
		// reference of type HomePage
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
