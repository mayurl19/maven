package kitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	// 1. Data member should be declared globally with access level private using
	// @findBy Annotation
	@FindBy(xpath = "//span[@class='user-id']")
	private WebElement UID;
	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement LogoutButton;

	// 2. Initialize within a constructor with access level public using pagefactory

	public KiteHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. Utilize within a method with access level public

	public String getActualUserID1() {
		String ActualUserID = UID.getText();
		return ActualUserID;
	}

	public void clickLogoutButton() {
		UID.click();
		LogoutButton.click();

	}

}
