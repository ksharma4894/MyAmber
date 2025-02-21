package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeaturePage {

	WebDriver ldriver;
	JavascriptExecutor js;

	public FeaturePage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);

	}

	@FindBy(css = "#nav-1")
	WebElement feature;
	@FindBy(xpath = "//div[normalize-space()='Easy For All']")
	WebElement easeofAll;
	@FindBy(xpath = "//div[normalize-space()='Information that everybody can access and understand']")
	WebElement easeOfAllText;

	@FindBy(xpath = "//div[normalize-space()='Emergency SOS']")
	WebElement emgSOS;
	@FindBy(xpath = "//div[normalize-space()='Instantly inform your contacts when you need urgent assistance']")
	WebElement sosText;

	@FindBy(xpath = "//div[normalize-space()='Risk Assessment']")
	WebElement riskasses;
	@FindBy(xpath = "//div[normalize-space()='Identify your risks with a self assessment test']")
	WebElement riskText;

	@FindBy(xpath = "//div[normalize-space()='Local Support']")
	WebElement localSupp;
	@FindBy(xpath = "//div[normalize-space()='Find Support that is within your reach']")
	WebElement localText;

	@FindBy(xpath = "//img[@alt='button']")
	WebElement googlePlayButton;

	public void featureHeader() {

		feature.click();
	}

	public String easeOfAll() {

		js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,500);");

		// Explicit Wait: Wait until 'easeofAll' is clickable
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(easeofAll));

		// Click on the element
		easeofAll.click();

		// Get the text
		String easeTxt = easeOfAllText.getText();
		return easeTxt;

	}

	public String emergencySOS() {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(emgSOS));
		emgSOS.click();

		// Wait for text to appear
		wait.until(ExpectedConditions.visibilityOf(sosText));

		String sosTxt = sosText.getText();
		return sosTxt;

	}

	public String riskAssesment() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(riskasses));
		riskasses.click();
		wait.until(ExpectedConditions.visibilityOf(riskText));
		
		String riskTxt = riskText.getText();
		return riskTxt;

	}

	public String localSuppot() {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(localSupp));
		localSupp.click();
		wait.until(ExpectedConditions.visibilityOf(localText));
		String localTxt = localText.getText();
		return localTxt;
	}

	public void scrollDownOnScreen() {
		js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,1000);");
	}

	public String googlePlayRedirection() {
		googlePlayButton.click();
		String myAmberPlayStore = ldriver.getCurrentUrl();
		return myAmberPlayStore;
	
	}

}