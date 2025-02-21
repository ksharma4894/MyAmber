package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {

	WebDriver ldriver;

	public AboutUsPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@FindBy(css = "#nav-3") 	WebElement aboutUs;

	public void clickOnAboutUs() {
		aboutUs.click();
	}

	public String confirmURL() {

		String aboutUsURL = ldriver.getCurrentUrl();
		return aboutUsURL;
	}
}
