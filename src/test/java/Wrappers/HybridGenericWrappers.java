package Wrappers;

import org.openqa.selenium.WebElement;

//import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openxmlformats.schemas.drawingml.x2006.chart.impl.STLegendPosImpl;
import org.testng.annotations.DataProvider;

//import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.reporting;

public class HybridGenericWrappers extends reporting implements Hybridwrappers {
	
	public static RemoteWebDriver driver;
	public static Properties prop;
	public static String excelfilepath, excelsheetnumber;
	
	public void invokeApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			// reportStep("The browser"+browser+"launched successfully with Url"+url);
			reportStep("The browser" + browser + "launched successfully with Url" + url, "Pass");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			// reportStep("The browser"+browser+"not launched due to session error");
			reportStep("The browser" + browser + "not launched due to session error", "Fail");
		} catch (WebDriverException e) {
			// reportStep("The browser"+browser+"not launched due to unknown error");
			reportStep("The browser" + browser + "not launched due to unknown error", "Fail");
		}
	}

	public void loadObjects() {

		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/object.properties"));
			// prop.load(new
			// FileInputStream("C:/Users/nups1/eclipse-workspace/hybridmodel/src/test/java/object.properties"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void unloadObjects() {
		prop=null;
	}
	
	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(idValue)).sendKeys(data);
			reportStep("The element with idValue" + idValue + "is entered with data" + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with idValue" + idValue + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			reportStep("The element with the idValue" + idValue + "is not visible in the appication", "Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the idValue" + idValue + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the idValue" + idValue + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep(
					"The element with idValue" + idValue + "is not entered with data" + data + "due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(nameValue)).sendKeys(data);
			reportStep("The element with Namevalue" + nameValue + "is entered with the data" + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Namevalue" + nameValue + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Namevalue"+nameValue+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Namevalue" + nameValue + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Namevalue" + nameValue + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Namevalue" + nameValue + "is not entered with the date" + data
					+ "due to unknown error", "Fail");
		} finally {
			takeSnap();
		}

	}

	public void enterByXpath(String xpathValue,String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			reportStep("The element with Xpathvalue" + xpathValue + "is entered with the data" + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpathValue + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpathValue+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpathValue + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpathValue + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + xpathValue + "is not entered with the date" + data
					+ "due to unkowm error", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void verifyTitle(String title) {

		// TODO Auto-generated method stub
		try {
			String Actualtitle = driver.getTitle();
			if (Actualtitle.equalsIgnoreCase(title)) {
				reportStep("Actualtitle" + Actualtitle + "is equals to expected titile" + title, "Pass");
			} else {
				reportStep("Actualtitle" + Actualtitle + "is not equals to expected titile" + title, "Fail");
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			reportStep("The window target to be switched is not found for the title" + title, "Fail");

		} catch (SessionNotCreatedException e) {
			reportStep("The Session is not created with the given title" + title, "Fail");
		} catch (NoSuchSessionException e) {
			reportStep("The session is not found with the given title" + title, "Fail");
		} catch (WebDriverException e) {
			reportStep("Due to unknown error title is not verified", "Fail");
		} finally {
			takeSnap();
		}
	}

	public String verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String Text1 = driver.findElement(By.id(id)).getText();

			if (text.equalsIgnoreCase(Text1)) {
				reportStep("Text actual text" + Text1 + "is equals to the expected text" + text, "Pass");
			} else {
				reportStep("Text actual text" + Text1 + "is not equals to the expected text" + text, "Fail");
			}
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with id" + id + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with id"+id+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Id" + id + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Id" + id + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with the Id" + id + "is not verifying the text due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
		return text;
	}

	public String verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String Text2 = driver.findElement(By.xpath(xpath)).getText();

			if (text.contains(Text2)) {
				reportStep("Text actual text" + Text2 + "is euals to the expected text" + text, "Pass");
			} else {
				reportStep("Text actual text" + Text2 + "is not euals to the expected text" + text, "Fail");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpath + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpath+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not verifying the text due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
		return text;
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String Text3 = driver.findElement(By.id(xpath)).getText();

			if (text.contains(Text3)) {
				reportStep("The actual text" + Text3 + "contains the expected text" + text, "Pass");
			} else {
				reportStep("The actual text" + Text3 + "is not contains the expected text" + text, "Fail");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpath + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpath+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with the Xpathvalue" + xpath + "is not verifying the text due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(id)).click();
			reportStep("The element with Id" + id + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with id" + id + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with id"+id+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the id" + id + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the id" + id + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Id" + id + "is not clicking the button due to unknown error", "Fail");
		} finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with ClassName" + classVal + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with ClassName" + classVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with ClassName"+classVal+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the ClassName" + classVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the ClassName" + classVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with ClassName" + classVal + "is not clicking the button due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(name)).click();
			reportStep("The element with namevalue" + name + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with namevalue" + name + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with namevalue"+name+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the namevalue" + name + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the name" + name + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with namevalue" + name + "is not clicking the button due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with linktextValue" + name + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with linktextValue" + name + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with linktextValue"+name+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the linktextValue" + name + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the linktextValue" + name + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with linktextValue" + name + "is not clicking the button due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with linktextvalue" + name + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with linktextvalue" + name + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with linktextvalue"+name+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the linktextvalue" + name + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the linktextvalue" + name + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with linktextvalue" + name + "is not clicking the button due to unkown error",
					"Fail");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element with Xpathvalue" + xpathVal + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpathVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpathVal+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + xpathVal + "is ot clicking the button due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element with Xpathvalue" + xpathVal + "is clicking the button", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpathVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpathVal+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + xpathVal + "is not clicking the button due to unknown error",
					"Fail");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		try {
			String Reqtext = driver.findElement(By.id(idVal)).getText();
			// reportStep(Reqtext);
			reportStep("The element with Id" + idVal + "is getting the text", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Id" + idVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Id"+idVal+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Id" + idVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Id" + idVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with id value" + idVal + "is not getting the text due to unknown error", "Fail");
		}
		return idVal;

	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String Requiredtext = driver.findElement(By.xpath(xpathVal)).getText();
			// reportStep(Requiredtext);
			reportStep("The element with Xpathvalue" + xpathVal + "is getting the text", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpathVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpathVal+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + xpathVal + "is not getting the text due to unknown error",
					"Fail");
		}
		return xpathVal;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element = driver.findElement(By.id(id));
			Select element1 = new Select(element);
			element1.selectByVisibleText(value);
			reportStep("The element with Id" + id + "is selecting the text" + value, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Id" + id + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Id"+id+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Id" + id + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Id" + id + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Id" + id + "is not selecting the text due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement element2 = driver.findElement(By.id(id));
			Select element3 = new Select(element2);
			element3.selectByIndex(value);
			reportStep("The element with Id" + id + "is selecting the text" + value, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Id" + id + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Id"+id+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Id" + id + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Id" + id + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Id" + id + "is not selecting the text due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> Allwindows = driver.getWindowHandles();
			for (String ParentWindow : Allwindows) {
				driver.switchTo().window(ParentWindow);
				break;
			}
			reportStep("Driver is Switched to parent window successfully", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			reportStep("The parent window target to be switched is not found", "Fail");

		} catch (SessionNotCreatedException e) {
			reportStep("The Session is not created for the parent window", "Fail");
		} catch (NoSuchSessionException e) {
			reportStep("The session is not found for the parent window", "Fail");
		} catch (WebDriverException e) {
			reportStep("Due to unknown error driver is not switched to parent window", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> Wind1 = driver.getWindowHandles();
			for (String Wind2 : Wind1) {
				driver.switchTo().window(Wind2);
			}
			reportStep("Driver is Switched to last window successfully", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			reportStep("The last window target to be switched is not found", "Fail");

		} catch (SessionNotCreatedException e) {
			reportStep("The Session is not created for the last window", "Fail");
		} catch (NoSuchSessionException e) {
			reportStep("The session is not found for the last window", "Fail");
		} catch (WebDriverException e) {
			reportStep("Due to unknown error driver is not switched to last window", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			reportStep("Accepted the Alert successfully in the Alert box", "Pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			reportStep("There is no alert to interact with in the pertucular instance", "Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The Alert is not inreractable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The Alert in the appication is not stable", "Fail");
		} catch (WebDriverException e) {
			reportStep("Not accepted the Alert due to unknown error", "Fail");
		} finally {
			takeSnap();
		}

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			reportStep("Dismiss the Alert successfully in the Alert box", "Pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			reportStep("There is no alert to interact with in the pertucular instance", "Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The Alert is not inreractable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The Alert in the appication is not stable", "Fail");
		} catch (WebDriverException e) {
			reportStep("Not dismiss the Alert due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String alerttext = "";
		try {
			driver.switchTo().alert().getText();
			reportStep("Got the text from the Alert box successfully", "pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			reportStep("There is no alert to interact with in the pertucular instance", "Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The Alert is not inreractable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The Alert in the appication is not stable", "Fail");
		} catch (WebDriverException e) {
			reportStep("Not dismiss the Alert due to unknown error", "Fail");
		}
		return alerttext;

	}

	int i = 1;

	public long takeSnap() {
		// TODO Auto-generated method stub
		try {
			File temp = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			File dest = new File("./screesnshots/snap" + i + ".png");
			FileUtils.copyFile(temp, dest);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			reportStep("Input/Output file operation issue", "Fail");

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("The browser got closed due to unknown error", "Fail");
		}
		return i++;

	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			reportStep("Browser got closed successfully", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			reportStep("There is no such window to close at this instance ", "Fail");
		} catch (WebDriverException e) {
			reportStep("The window not closed due to unknown error", "Fail");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			reportStep("All Browsers are closed successfully", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			reportStep("There is no such windows to close at this instance ", "Fail");
		} catch (WebDriverException e) {
			reportStep("All the windows are not closed due to unknown error", "Fail");
		}
	}

	public void waittime(long arg0) throws InterruptedException {
		Thread.sleep(arg0);
	}
	
	public void selectValueById(String IdVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(IdVal))).selectByValue(data);
			//System.out.println("Element with" + IdVal + " is selected using Value of " + data);
			reportStep("The element with ID "+IdVal+ " is selected by Value with " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep(IdVal + " Element Select by Value is not found" + data+" Please correct locator.","Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep(IdVal + " Element is not interactable in the application.","Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep(IdVal + " Element is not stale in the application.","Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep(IdVal + " Element is not entering value beacuse of  unknown error.","Fail");
		}
	}

	public void selectVisibileTextByXPath(String Xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element2 = driver.findElement(By.xpath(Xpath));
			Select element3 = new Select(element2);
			element3.selectByVisibleText(value);
			reportStep("The element with Xpathvalue" + Xpath + "is selecting the text" + value, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + Xpath + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+Xpath+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + Xpath + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + Xpath + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + Xpath + "is not selecting the text due to unknown error",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void selectVisibileTextByName(String Name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement item = driver.findElement(By.name(Name));
			Select itemtoselect = new Select(item);
			itemtoselect.selectByVisibleText(value);
			reportStep("The element with Name" + Name + "is selecting the text" + value, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Name" + Name + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Name"+Name+"is not visible in the
			// appication","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Name" + Name + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Name" + Name + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Name" + Name + "is not selecting the text due to unknown error", "Fail");
		} finally {
			takeSnap();
		}

	}

	public void enterByIdTab(String idValue) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(idValue)).sendKeys(Keys.TAB);
			reportStep("The element with idValue" + idValue + "is moving to next element with the input", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with idValue" + idValue + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with idValue"+idValue+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the idValue" + idValue + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the idValue" + idValue + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with idValue" + idValue + "is not moving to next element with the input", "Fail");
		} finally {
			takeSnap();
		}
	}

	public void enterTabByXpath(String Xpath) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(Xpath)).sendKeys(Keys.TAB);
			reportStep("The element with Xpathvalue" + Xpath + "is moving to next element", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + Xpath + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+Xpath+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + Xpath + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + Xpath + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + Xpath + "is not moving to next element", "Fail");
		} finally {
			takeSnap();
		}

	}

	public String getAttributeValueByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		try {
			String valueatt = driver.findElement(By.xpath(xpathVal)).getAttribute(value);
			// reportStep(valueatt);
			reportStep("The element with Xpathvalue" + xpathVal + "is getting the text", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Xpathvalue" + xpathVal + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Xpathvalue"+xpathVal+"is not visible in the
			// appication");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Xpathvalue" + xpathVal + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Xpathvalue" + xpathVal + "is not getting the text due to unknown error",
					"Fail");
		}
		return value;
	}

	public void enterByNameTab(String NameValue) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(NameValue)).sendKeys(Keys.TAB);
			reportStep("The element with NameValue" + NameValue + "is moving to next element with the input", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with NameValue" + NameValue + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with NameValue"+NameValue+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the NameValue" + NameValue + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the NameValue" + NameValue + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with NameValue" + NameValue + "is not moving to next element with the input",
					"Fail");
		} finally {
			takeSnap();
		}
	}

	public void enterByClassName(String ClassName, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.className(ClassName)).sendKeys(data);
			reportStep("The element with ClassValue" + ClassName + "is entered with the data" + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with ClassValue" + ClassName + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with ClassValue"+ClassName+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the ClassValue" + ClassName + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the ClassValue" + ClassName + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with ClassValue" + ClassName + "is not entered with the date" + data
					+ "due to unknown error", "Fail");
		} finally {
			takeSnap();
		}

	}

	public void enterTabByClassName(String ClassName) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.className(ClassName)).sendKeys(Keys.TAB);
			reportStep("The element with ClassName" + ClassName + "is moving to next element with the input", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with ClassName" + ClassName + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with ClassName"+ClassName+"is not visible in the
			// application","Fail");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the ClassName" + ClassName + "is not interactable", "Fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The element with the ClassName" + ClassName + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with ClassName" + ClassName + "is not moving to next element with the input",
					"Fail");
		} finally {
			takeSnap();
		}

	}

	public void selectIndexValueByName(String Name, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement element2 = driver.findElement(By.name(Name));
			Select element3 = new Select(element2);
			element3.selectByIndex(value);
			reportStep("The element with Namevalue" + Name + "is selecting the text", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with Namevalue" + Name + "is not available in the DOM", "Fail");
			// }catch(ElementNotVisibleException e){
			// reportStep("The element with Namevalue"+Name+"is not visible in the
			// appication");
		} catch (ElementNotInteractableException e) {
			reportStep("The element with the Namevalue" + Name + "is not interactable", "Fail");

		} catch (StaleElementReferenceException e) {
			reportStep("The element with the Namevalue" + Name + "is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			reportStep("The element with Namevalue" + Name + "is not selecting the text due to unknown error", "Fail");
		} finally {
			takeSnap();
		}
	
	}

		@DataProvider(name="ExcelDataProvider")
		public String[][] getexceldata() throws IOException{
				
		String[][]data;

		FileInputStream fis = new FileInputStream(excelfilepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheetAt(Integer.decode(excelsheetnumber));
		int rowcount=Sheet.getLastRowNum();
		int columncount = Sheet.getRow(0).getLastCellNum();
		data= new String[rowcount][columncount];

		for(int i=1;i<=(rowcount);i++)
		{
			XSSFRow Row=Sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				String cellData = Row.getCell(j).getStringCellValue();
				data[i-1][j] = cellData;
				
			}
		}return data;



		}



		

	
	
	}


