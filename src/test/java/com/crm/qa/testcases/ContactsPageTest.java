package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutils;
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		testutils = new TestUtil();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyContactsNameTest() {
		Assert.assertTrue(contactspage.verifyContactsName());
	}
	
	@Test(priority=2)
	public void deleteMemberTest() {
		contactspage = homepage.clickOnContactsLink();
		homepage.hoverback();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		contactspage.clickCheckbox();
		contactspage.clickActionButton();
		contactspage.deleteOptionClick();
		contactspage.clickCheckMark();
		contactspage.clickDeleteBtn();
		Assert.assertFalse(contactspage.verifySecondUserName());	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
