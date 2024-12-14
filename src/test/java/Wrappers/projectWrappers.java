package Wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


	public class projectWrappers extends HybridGenericWrappers {

		public String browser;
		public String appname;

		@BeforeSuite
		public void BeforeSuit() {
			StartReport();
		}
		@BeforeClass
		public void beforeClass()
		{
			testCaseName = "FBRegistrationPageTestCase";
			testCaseDescription="To Verify Facebook Registration Page Using POM";
			author="Meenu";
			category="Smoke";
			browser="chrome";
			appname="Facebook";
			excelfilepath = "C:\\Users\\vijay\\eclipse-workspace\\HybridFramework\\TestData\\TC002.xlsx";
			excelsheetnumber = "0";
		}
		@BeforeTest
		public void beforeTest() {
			loadObjects();
		}
		
		
		@BeforeMethod
		public void beforeMethod() {
			startTest(testCaseName, testCaseDescription);
			if(appname.equalsIgnoreCase("Facebook"))
			{
				invokeApp(browser, "https://www.facebook.com");
			}
			else if(appname.equalsIgnoreCase("IRCTC"))
			{
				invokeApp(browser, "https://www.irctc.co.in/nget/train-search");
			}
			else if(appname.equalsIgnoreCase("Twitter"))
			{
				invokeApp(browser, "https://twitter.com");	
			}
			//waitDriver(3000);
		}

		/*@AfterMethod
		public void afterMethod() {
			closeAllBrowsers();
		}*/

		@AfterClass
		public void afterClass() {
			endTest();
		}

		@AfterTest
		public void afterTest() {
			unloadObjects();
		}

		@AfterSuite
		public void afterSuit() {
			endReport();
		}

	}

	
	

