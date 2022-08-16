package kitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {
	// 1. Data member should be declared globally with access level private using  @findBy Annotation

	@FindBy(id = "userid")
	private WebElement UserID;
	@FindBy(id = "password")
	private WebElement PassWard;
	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement LoginButton;

	// 2. Initialize within a constructor with access level public using pagefactor
	public KiteLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. Utilize within a method with access level public
	public void sendUserID(String UN) {
		UserID.sendKeys(UN);

	}

	public void SendPassWard(String PWD) {
		PassWard.sendKeys(PWD);
	}

	public void clickLoginButton() {
		LoginButton.click();
	}
}
