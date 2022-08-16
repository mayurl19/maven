 package kitetestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseNew;
import kitePomClasses.KiteHomePage;
import kitePomClasses.KiteLoginPage;
import kitePomClasses.KitePinPage;
import utilityClass.UtilityNew;

@Listeners(utilityClass.Listener.class)
public class ValidatedKiteAppWithPropertyFile extends BaseNew implements ITestListener {
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage home;

	@BeforeClass
	public void launchingBrowser() throws IOException {
		openApp();

		login = new KiteLoginPage(driver);
		pin = new KitePinPage(driver);
		home = new KiteHomePage(driver);
	}

	@BeforeMethod
	public void loginToKiteApp() throws EncryptedDocumentException, IOException {
		login.sendUserID(UtilityNew.dataFromMyProperty("UN"));
		Reporter.log("Sending UserID", true);
		login.SendPassWard(UtilityNew.dataFromMyProperty("PWD"));
		Reporter.log("Sending passward", true);
		login.clickLoginButton();
		Reporter.log("Clicking on login button", true);
		UtilityNew.waits(driver, 1000);
		pin.sendPin(UtilityNew.dataFromMyProperty("PIN"));
		UtilityNew.waits(driver, 500);
		Reporter.log("Sending pin", true);
		pin.clickContinueButton();
		Reporter.log("Clicking on continue button", true);
		UtilityNew.waits(driver, 1000);
	}

	@Test
	public void KiteUserValidate() throws EncryptedDocumentException, IOException {
		// String TCID = "2366";
		Assert.assertEquals(home.getActualUserID1(), UtilityNew.dataFromMyProperty("UN1"),
				"TC is Failed actual and ecpected are not match");
		Reporter.log("validating UserID", true);
		// UtilityNew.captureScreenshot(driver, TCID);

	}

	@AfterMethod
	public void logOutKiteApp() {
		home.clickLogoutButton();
		Reporter.log("Clicking on logOut button", true);
		UtilityNew.waits(driver, 500);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Closing the browser", true);
	}
}
