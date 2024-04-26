package BillingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonGuidewire.BaseGuidewirePage;
import junit.framework.Assert;
import pageObjectModel.BaseTest;
import qaDataAccess.TestDataReader;

public class BaseTestBilling extends BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public qaDataAccess.TestDataReader reader;
	String usernameGW, passwordGW , gwEnv ,s3env;
	String gwLoginsheet = "gwEnv";
	BaseGuidewirePage baseGuidewirePage;
	String credentialsSheet = "\\TestData.xlsx";
	String projectDirectory = System.getProperty("user.dir");
	String urlString = "";
	
	public void loginToApp(String tag) {

			//String appTitleBeforeLogin = driver.getTitle();
	        navigateToURL(super.getEnvironmentURL(tag));
			loginByTag(tag);
			//Assert.assertTrue(new BaseGuidewirePage(driver, wait).waitUntilPageTitleChange(appTitleBeforeLogin), "Verify User successfully got logged in");	

	    }
	
	public void loginByTag(String tag) {
		TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "\\TestData.xlsx");
		String Username = reader.getCellData("URL", reader.getRowByKey("URL", "Tag", tag),
				reader.getColumnByKey("URL", "Username"));
		String Password = reader.getCellData("URL", reader.getRowByKey("URL", "Tag", tag),
				reader.getColumnByKey("URL", "Password"));
		new BaseGuidewirePage(driver, wait).inputCredentials(Username, Password);
	}

	public void navigateToURL(String url){
			this.driver.get(url);

		}
}
