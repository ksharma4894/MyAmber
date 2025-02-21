package PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.StepDefination;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//a[text()=' Skip']")
	WebElement skip;
	@FindBy(xpath = "//div[contains(text(),'SOS Page')]")
	WebElement sosButton;

	@FindBy(xpath = "//div[contains(text(),'Learning about your emotions and responses')]")
	WebElement learningEmotion;

	@FindBy(xpath = "//div[contains(text(),'Healthcare and Medical Testing')]")
	WebElement healthCare;

	@FindBy(xpath = "//div[contains(text(),'Access to legal and judicial forums')]")
	WebElement jurdicalForms;
	// Below are the method added for Home Page
	@FindBy(xpath = "//div[contains(text(),'Self-Care Toolbox')]")
	WebElement selefCare;

	@FindBy(xpath = "//div[contains(text(),'Empowered Voices')]")
	WebElement empVoice;

	@FindBy(xpath = "//div[contains(text(),'Standing with Survivors')]")
	WebElement surviros;

	@FindBy(xpath = "//div[@id='scrollingToTop']")
	WebElement dir;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginButton;

	@FindBy(xpath = "//button[normalize-space()='Facebook']")
	WebElement facebook;
	@FindBy(xpath = "//button[normalize-space()='Google']") WebElement google;
	
	@FindBy(id = "email")
	WebElement id;
	@FindBy(id = "identifierId") WebElement emailfield;
	
	@FindBy(xpath = "//span[text()='Next']") WebElement nxtBtn;
	
	
	@FindBy(id = "pass")
	WebElement passwd;
	@FindBy(xpath = "//input[@name='Passwd']") WebElement pwdBtn;
	
	@FindBy(id = "loginbutton")
	WebElement loginBtn;

	public void skipGuide() {

		try {

			if (skip.isDisplayed()) {
				skip.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Click on SOS button
	public void sosButton() {

		sosButton.click();
	}

	// Click on Learning about your emotions and responses button
	public void learningEmotions() {
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		learningEmotion.click();
	}

	public void healthCare() {
		healthCare.click();

	}

	public void accessToLeagal() {

		jurdicalForms.click();
	}

	public void selfCareToolbox() {
		selefCare.click();

	}

	public void empoweredVoice() {
		empVoice.click();

	}

	public void stadingSupviosr() {
		surviros.click();

	}

	public void directory() {

		dir.click();
	}

	public void login() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		
		loginButton.click();
	}

	public void clickGoogle(String email, String pwd) {
		
		String amberid = ldriver.getWindowHandle();
		google.click();
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Step 4: Switch to Facebook Login Window
		Set<String> allWindows = ldriver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(amberid)) {
				System.out.println("this is the window handles of Fb Login" +window);
				ldriver.switchTo().window(window);
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOf(emailfield));
		emailfield.sendKeys(email);
        nxtBtn.click();
		pwdBtn.sendKeys(pwd);
		nxtBtn.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		ldriver.switchTo().window(amberid);
	}

}
