package Wrappers;

import org.openqa.selenium.WebElement;

public interface Hybridwrappers {

		public void invokeApp(String browser, String url);


		public void enterById(String idValue, String data);



		public void enterByName(String nameValue, String data) ;


		public void enterByXpath(String xpathValue, String data);


		public String verifyTextById(String id, String text);


		public String verifyTextByXpath(String xpath, String text);


		public void verifyTextContainsByXpath(String xpath, String text);


		public void clickById(String id) ;


		public void clickByClassName(String classVal);


		public void clickByName(String name) ;



		public void clickByLink(String link);



		public void clickByXpath(String xpathVal);


		public String getTextById(String idVal);


		public String getTextByXpath(String xpathVal);

		//public String switchToParentWindow();

		public void switchToParentWindow();
		public void switchToLastWindow();

		public void closeBrowser();


		public void closeAllBrowsers();


				//public void selectVisibileTextById(String countryCode, String value);
}