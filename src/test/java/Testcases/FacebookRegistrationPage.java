package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Wrappers.HybridGenericWrappers;

public class FacebookRegistrationPage extends HybridGenericWrappers {

	public FacebookRegistrationPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	public FacebookRegistrationPage enterFirstname(String Firstname) throws InterruptedException {

		enterByXpath(prop.getProperty("FaceBooKRegistrationPage.FirstName.ByXpath"), Firstname);
		return this;
	}

	public FacebookRegistrationPage enterLastname(String Lastname) throws InterruptedException {

		enterByName(prop.getProperty("FaceBooKRegistrationPage.LastName.ByName"), Lastname);
		return this;

	}

	public FacebookRegistrationPage setDate(String Date) {

		String[] DOB = Date.split("/");
		
		selectValueById(prop.getProperty("FaceBooKRegistrationPage.BirthDay.ID"), DOB[0]);
		selectVisibileTextById(prop.getProperty("FaceBooKRegistrationPage.BirthMonth.ID"), DOB[1]);
		selectVisibileTextById(prop.getProperty("FaceBooKRegistrationPage.BirthYear.ID"), DOB[2]);

		return this;

	}
	public FacebookRegistrationPage Gender (String sex) {
		
	    String gender;
		gender =  verifyTextByXpath("FaceBookRegistrationPage.GenderTitle.Xpath",sex);
		if(gender.equals(sex)) {
		switch(gender) {
		case "Female":
		clickByXpath(prop.getProperty("FaceBookRegistrationPage.GenderFemale.Xpath"));
		break;
		case "Male":
			clickByXpath(prop.getProperty("FaceBookRegistrationPage.GenderMale.Xpath"));
			break;
		case "Custom":
			clickByXpath(prop.getProperty("FaceBookRegistrationPage.GenderCustom.Xpath"));
			break;
		}
		
		
	}
		return this;
		
	} 
	

	public FacebookRegistrationPage enterEmailID(String email) {
		enterByName(prop.getProperty("FaceBooKRegistrationPage.Email.ByName"), email);
		return this;

	}

	public FacebookRegistrationPage enterPassword(String pass) {
		enterByName(prop.getProperty("FaceBooKRegistrationPage.Password.ByName"), pass);
		return this;

	}
	public void chumma(String HI) {
		System.out.printf("Hello",HI);
	}
}
