package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
    @FindBy(xpath= "//span[text()='vineeth g']")	
	
	//@CacheLookup---- > This used to improve the script performance
	
	                     /* By using this annotation, iam creating one cache memory then what will happen is like it will store the particular element into cache memory
	                     now if you are doing any actions by using the particular element it will not go to the browser, it will directly pick it from the cache memory
	                     we created */
	
	// Disadvantages of using @CacheLookup is that , suppose if our page got refreshed then DOM property of the particular page will get changed,  then the cache memory will be correpted so in that case 'stale element exception' will be thrown
	
	WebElement usernamelabel;
	
	@FindBy(xpath= "//span[text()='Contacts']")	
	WebElement contactslink;
	
	@FindBy(xpath= "//span[text()='Deals']")	
	WebElement dealslink;
	
	@FindBy(xpath= "//span[text()='Tasks']")	
	WebElement taskslink;
	
	
	public HomePage() {
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle() {
		
	 return driver.getTitle();
		
	}
	
	
	public Boolean verifycorrectusername() {
		
		return usernamelabel.isDisplayed();
		
	}
	
	
	public Contactspage Clickoncontactslink() {   // here the return type of  Clickoncontactslink method is Contactspage cz after clicking onto contacslink it will go to contacts page
		
		                                          // When we click on contactslink it should return contacts page object, similarly for the other links also
		contactslink.click();
		
		return new Contactspage();   
	}
	
	
    public Dealspage Clickondealslink() {   // here the return type of  Clickondealslink method is Dealspage cz after clicking onto dealslink it will go to deals page
		
		
    	dealslink.click();
		
		return new Dealspage();
	
	
    }
    
    public TasksPage Clickontaskslink() {   // here the return type of   Clickontaskslink method is TasksPage cz after clicking onto taskslink it will go to TasksPage
		
		
    	taskslink.click();
		
		return new TasksPage();
	
	
    }
		

}
