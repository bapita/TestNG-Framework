package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddContactsPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeAccountPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class AddContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	AddContactsPage addcontactspage;
	FreeAccountPage freeaccountpage;
	TestUtil testutil;
	
	String sheetname = "contacts";

	public AddContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		addcontactspage = new AddContactsPage();
		freeaccountpage = new FreeAccountPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyAddNewContactsPageTest() {
		homepage.hoverOnLink();
		homepage.clickOnContactsLink();
		addcontactspage = contactspage.clickPlusButton();
		Assert.assertTrue(addcontactspage.verifyAddNewContactsPage());
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetname); // 2D object array in return
		return data;
	}

	@Test(priority = 2, dataProvider="getTestData")
	public void createNewContactTest(String fname, String lname) {
		homepage.hoverOnLink();
		contactspage = homepage.clickOnContactsLink();
		addcontactspage = contactspage.clickPlusButton();
		addcontactspage.clickOnFirstname();
		addcontactspage.clickOnLastname();
		//freeaccountpage = addcontactspage.createNewContact("john", "cena");
		freeaccountpage = addcontactspage.createNewContact(fname, lname);

	}
	
	@Test(priority = 3)
	public void checkNewContactTest() {
		contactspage = homepage.clickOnContactsLink();
		homepage.hoverback();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String addedname = contactspage.checkAddedName();
		Assert.assertEquals(addedname, "Mukta Sharma", "Contact's name not matched");
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

}
