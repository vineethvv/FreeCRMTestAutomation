package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Contactspage extends TestBase {
	
	
    @FindBy(xpath= "//div[text()='Contacts']")
	
	WebElement contactslabel;
	
	@FindBy(xpath="//button[text()='New']")
	
	WebElement newcontact;
		

	@FindBy(name="first_name")
	
	WebElement firstname;
	
    @FindBy(name="last_name")
	
	WebElement lastname;
    
    @FindBy(xpath="//div[@name='company']")
	
  	WebElement company;
    
    @FindBy(xpath="//button[text()='Save']")
    
    WebElement savebutton;
	

    public Contactspage() {
		
		
		PageFactory.initElements(driver, this);
	}
    
    
    public boolean verifycontactslabel() {
    	
    	return contactslabel.isDisplayed();
    	
    }
    
    public void selectcontactsByName(String name) {
    	
    	driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td")).click();
    	
    }
    
    
    public void clickonnewcontactlink() {
    	
    	newcontact.click();
    	
    }
    
    
    public void createnewcontact(String ftname, String ltname){
    	
    	
    	firstname.sendKeys(ftname);
    	lastname.sendKeys(ltname);
    	//company.sendKeys(comp);
    	savebutton.click();
    	
    	
    	
    }

}
