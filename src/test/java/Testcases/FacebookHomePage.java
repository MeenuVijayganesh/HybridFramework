package Testcases;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Wrappers.HybridGenericWrappers;

public class FacebookHomePage extends HybridGenericWrappers {
	
	public FacebookHomePage(RemoteWebDriver driver,ExtentTest test) {
		
		this.driver= driver;
		this.test = test;
		
		
	}
	public  FacebookRegistrationPage CreateNewAccount ()throws InterruptedException {
		clickByXpath(prop.getProperty("FaceBookHomePage.Createnewbutton.BYXpath"));
		return new FacebookRegistrationPage(driver,test);
	}

}
