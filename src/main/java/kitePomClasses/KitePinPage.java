package kitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinPage {
	// 1. Data member should be declared globally with access level private using
	// @findBy Annotation
	@FindBy(id = "pin")
	private WebElement Pin;
	@FindBy(xpath = "//button[text()='Continue ']")
	private WebElement ContinueButton;

	// 2. Initialize within a constructor with access level public using pagefactor
	public KitePinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. Utilize within a method with access level public

	public void sendPin(String PIN) {
		Pin.sendKeys(PIN);
	}

	public void clickContinueButton() {
		ContinueButton.click();
	}
}
