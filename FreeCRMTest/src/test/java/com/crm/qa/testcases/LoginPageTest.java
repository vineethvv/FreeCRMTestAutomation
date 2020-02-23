package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase {
	
	
	
	Loginpage loginpage;  // defining
	HomePage  homePage ;   // 'homePage' is the 'HomePage' class reference variable 
	
	
	
	// constructor of class LoginPageTest
		
	public LoginPageTest() {
		
		super();   // super class which is used to call the constructor TestBase from TestBase.java
	}

	
	@BeforeMethod
	
	public void setup() {
		
		initialization();
		
		loginpage = new Loginpage();  // this object is created to acess all the methods from Loginpage.java 
	}
	
	
	@Test(priority=1)
	
	public void loginpagetitletest() {
		
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	
	@Test(priority=2)
	
	public void LoginTest() {
		
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}

}
