package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase {
	
	
	
	//Page factory or Obj repository
	
		@FindBy(xpath="//span[text()=' sign up']")
		WebElement signUpBtn;
		
		@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
		WebElement homelogin;
		
		@FindBy(name="email")	
		WebElement email;
		
		@FindBy(name="password")
		WebElement password;
		
		
		@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
		WebElement loginBtn;
		
		
		
		// constructor of class TestBase
		
		// Initializing the page factory
		
		public Loginpage() {
			
			
			PageFactory.initElements(driver, this);  // this---> means it pointing to the current class object 
			
		}
		
		
		//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			
			public HomePage login(String un, String pwd){   // here the return type of login method is HomePage cz HomePage is the landing page of LoginPage
				
				homelogin.click();
				email.sendKeys(un);
				password.sendKeys(pwd);
				loginBtn.click();
				
				return new HomePage();
							
		
	}

}
