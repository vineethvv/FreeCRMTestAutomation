package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class HomePageTest  extends TestBase {
	
	Loginpage loginpage;
	HomePage  homePage ;
	Contactspage Contactspages;
	
	
        public HomePageTest() {
		
		super();   // super class which is used to call the constructor TestBase from TestBase.java
	}
        
        
    	@BeforeMethod
    	
    	public void setup() {
    		
    		initialization();
    		
    		Contactspages = new Contactspage();
    		
    		loginpage = new Loginpage();  // this object is created to acess all the methods from Loginpage.java 
    		
    		homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    		
    	}
    	
    	
    	@Test(priority=1)
    	
    	public void VerifyHomepagetitletest() {
    		
    		String homepagetitle = homePage.validateHomePageTitle();
    		Assert.assertEquals(homepagetitle, "Cogmento CRM", "Home page title not matched");
    		
    	}
    	
    	
    	@Test(priority=2)
    	
    	public void verifyusernametest() {
    		
    		
    		Assert.assertTrue(homePage.verifycorrectusername());
    	}
    	
    	@Test(priority=3)
    	
    	public void verifycontactslinktest() {
    		
    		
    		Contactspages= homePage.Clickoncontactslink();
    	}
    	
    	
	
    	
    	
    	
    	@AfterMethod
    	
    	public void teardown() {
    		
    		driver.quit();
    	}
        

}
