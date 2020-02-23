package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
	// constructor of class TestBase
	
	public TestBase() {
		       
       
		try {
			
			prop = new Properties();
			
			FileInputStream	ip = new FileInputStream("C:\\Users\\Vineeth\\git\\FreeCRMTestAutomation\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			// to load the file by using properties, to load the file we have to use the object name 'prop'
			
			prop.load(ip);
					
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
			
	}
		
	   public static void initialization() {
		
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
		    
		    
	        System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
			
			// to launch the browser
			
			driver = new ChromeDriver();			
			
		    }else if(browsername.equals("firefox")) {
		    	
		    	 System.setProperty("webdriver.chrome.driver", "E:\\selenium jar files\\chrome driver\\geckodriver.exe");
		    	 
		    	 driver = new FirefoxDriver();
		    }
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		 // to maximize the page
		
		driver.manage().window().maximize();
		
		// to delete all cache
		
	     driver.manage().deleteAllCookies();
	     
	     driver.get(prop.getProperty("url"));
	     
	     driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		    
		
	}

}
