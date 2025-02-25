package PageObject;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v130.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Helper;

import java.util.Random;

public class UserPage {

	WebDriver driver;
	Random random = new Random();
	public WebDriverWait wait;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// Click on MyProfile Header
	@FindBy(xpath = "//a[text()=' My Profile ']")
	WebElement myProfile;
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//a[normalize-space()='Update Profile']")
	WebElement updateProf;

	// for profile Page
	@FindBy(xpath = "//input[@placeholder='Enter your name']")
	WebElement name;
	@FindBy(xpath = "//a[text()=' 16-25 ']")
	WebElement age;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateBtn;
	@FindBy(xpath = "//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")
	WebElement profileUpdate;

	// below are of am I at risk section
	@FindBy(xpath = "//label[text()='No']")
	WebElement no;

	// Emgcontact
	@FindBy(xpath = "//span[text()='Emergency Contacts']")
	WebElement emgConc;
	@FindBy(xpath = "//input[@placeholder='Name of your contact']")
	WebElement emgName;
	@FindBy(xpath = "//input[@placeholder='Enter phone number']")
	WebElement phoneNumber;
	@FindBy(xpath = "//button[@class='add-number']")
	WebElement plusIcon;
	@FindBy(xpath = "//a[@class='dail mr-1']")
	WebElement editicn;
	@FindBy(xpath = "//a[@class='dail']")
	WebElement delIcon;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement deletContact;

	// Directory
	@FindBy(xpath = "//a[@href='/user/directory']")
	WebElement directory;
	@FindBy(xpath = "//div[@class='ngx-select__toggle btn form-control']")
	WebElement selectCity;
	@FindBy(xpath = "//input[@placeholder='Select City']")
	WebElement cityList;
	@FindBy(xpath = "//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")
	WebElement srcConfig;

	public void updateProfile() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		myProfile.click();
		dashboard.click();
		wait.until(ExpectedConditions.visibilityOf(updateProf));

		updateProf.click();
	}

	public String myProfile(String nme) {
		name.clear();
		name.sendKeys(nme);
		age.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		System.out.println("Abot to Scroll o screen");
		wait.until(ExpectedConditions.visibilityOf(updateBtn));
		updateBtn.click();
		wait.until(ExpectedConditions.visibilityOf(profileUpdate));
		return profileUpdate.getText();

	}

	public void amIAtRrisk() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 1; i <= 10; i++) {

			// Wait for the question to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='chat']")));

			// Get Yes/No buttons
			List<WebElement> options = driver
					.findElements(By.xpath("//label[contains(text(),'Yes')]) or contains(text(),'No')]"));

			// Click a random option
			if (!options.isEmpty()) {
				WebElement randomOption = options.get(random.nextInt(options.size()));

				randomOption.click();
			}
		}

		// Click the submit button after the last question
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-button")));
		submitButton.click();

		// Verify informational message is displayed
		WebElement message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' User questionaires added successfully ']")));
		System.out.println("Informational message displayed: " + message.getText());

	}

	public void clickEmgContacts() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(emgConc));
		emgConc.click();
	}

	public void addContact(String name, String num) {

		emgName.sendKeys(name);
		phoneNumber.sendKeys(num);
	}

	public void clickOnPlus() {
		plusIcon.click();

	}

	public void clickEditIcon(String name) {

		editicn.click();
		emgName.clear();
		emgName.sendKeys(name);
		plusIcon.click();
	}

	public void delete() {
		delIcon.click();
		deletContact.click();

	}

	public void directorySection()

	{
		directory.click();

	}

	public String searchArea(String city)

	{
		selectCity.click();
		cityList.sendKeys(city);
		cityList.sendKeys(Keys.ENTER);
		String confirmation = srcConfig.getText();
		return confirmation;

	}

}
