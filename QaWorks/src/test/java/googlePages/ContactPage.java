package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.google.inject.Inject;

import framework.EventBrowser;
import framework.GetProperties;

public class ContactPage extends LoadableComponent<ContactPage> {

	private static String URL;
	private final WebDriver driver;

	@Inject GetProperties gp;
	@FindBy (id = "ctl00_MainContent_NameBox") private WebElement nameField;
	@FindBy (id = "ctl00_MainContent_EmailBox") private WebElement emailField;
	@FindBy (id = "ctl00_MainContent_MessageBox") private WebElement messageField;
	@FindBy (id = "ctl00_MainContent_SendButton") private WebElement sendButton;


	@Inject
	public ContactPage(EventBrowser driver) {
		this.driver = driver;
		URL = gp.getProperty("url");
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		driver.get(URL);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().contains(URL),
				"Wrong page was displayed: " + driver.getCurrentUrl());
	}

	public void typeName(String name) {
		nameField.sendKeys(name);
	}

	public void typeEmail(String email) {
		emailField.sendKeys(email);
	}

	public void typeMessage(String message) {
		messageField.sendKeys(message);
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public boolean errorMessage(String errorText) {
		String errorPath = "//span[contains(text(),'" + errorText
				+ "') and (contains(@style,'visible'))]";
		return driver.findElements(By.xpath(errorPath)).size() > 0;
	}

	public boolean confirmationMessageIsDisplayed(String confirmationMessage) {
		String confirmation = "//span[contains(text(),'" + confirmationMessage + "')]";
		return driver.findElements(By.xpath(confirmation)).size() > 0;
	}

}
