package POTestcases;

import org.testng.annotations.Test;

import Testcases.FacebookHomePage;
import Wrappers.HybridGenericWrappers;
import Wrappers.projectWrappers;

public class FBRegistrationPageTestCase extends projectWrappers {
@Test
(description="FBRegistrationPageTestCase",enabled=true,priority = 0,dataProvider = "ExcelDataProvider",dataProviderClass=HybridGenericWrappers.class)
public void FBRegistrationPageTestCase(String Firstname,String Lastname,String Date,String Gender,String Email,String Pass) throws InterruptedException
{
	new FacebookHomePage(driver, test)
	.CreateNewAccount()
	.enterFirstname(Firstname)
	.enterLastname(Lastname)
	.setDate(Date)
	.Gender(Gender)
	.enterEmailID(Email)
	.enterPassword(Pass);
	
}
}
