package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	Loginpage loginpage;
	HomePage  homePage ;
	Contactspage Contactspages;
	
	String sheetName= "Contacts";
	
	
     public ContactsPageTest() {
		
		super();   // super class which is used to call the constructor TestBase from TestBase.java
	}
     
     
        @BeforeMethod
 	
 	    public void setup() {
 		
 		initialization();
 		
 		Contactspages = new Contactspage();
 		
 		loginpage = new Loginpage();  // this object is created to acess all the methods from Loginpage.java 
 		
 		homePage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
 		
 		Contactspages = homePage.Clickoncontactslink();
 		
 		driver.navigate().refresh();
 		
 	}
     
     
     @Test(priority=1)
     
     public void verifycontactspagelabel() {
    	 
    	 Assert.assertTrue(Contactspages.verifycontactslabel(), "Contacts label is missing on the page");
     }
     
     @Test(priority=2)
     
     public void selectsinglecontactstest() {
    	 
    	 Contactspages.selectcontactsByName("test 2 test 2 lose");
     }
     
     

     @Test(priority=3)
     
     public void selectmultiplecontactstest() {
    	 
    	 Contactspages.selectcontactsByName("test 2 test 2 lose");
    	 Contactspages.selectcontactsByName("test 2 test 2");
     }
     
     
     @DataProvider
     
     public Object[][] getCRMTestData() {
    	 
    	 
    	 Object data [][] = TestUtil.getTestData(sheetName);
    	 
    	 return data;
     }
     
     
     @Test(priority=4, dataProvider= "getCRMTestData")
     
     public void validateCreateNewContact(String firstname, String lastname) {
    	 
    	 
    	 Contactspages.clickonnewcontactlink();
    	 Contactspages.createnewcontact(firstname, lastname);
     }
     
     
     @AfterMethod
 	
 	public void teardown() {
 		
 		driver.quit();
 	}
	

}
