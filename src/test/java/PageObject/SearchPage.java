package PageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver rDriver) {

		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//div[@class='header-search']//button")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@id='search-Text']")
	WebElement searchTxt;

	@FindBy(xpath = "//div[@class='header-search']//button")
	WebElement noResultFound;

	public String search(String search) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(searchIcon));

		WebElement srch = searchIcon;
		srch.click();
		searchTxt.sendKeys(search);
		searchTxt.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(noResultFound));
		String noResult = noResultFound.getText();
		return noResult;
	}

}
