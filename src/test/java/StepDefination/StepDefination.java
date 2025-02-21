package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import PageObject.AboutUsPage;
import PageObject.BrowserPage;
import PageObject.FeaturePage;
import PageObject.HomePage;
import PageObject.SearchPage;
import PageObject.UserPage;
import Utilities.Helper;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {

	static WebDriver driver;
	HomePage homePage;
	FeaturePage featuePage;
	SoftAssert softAssrt = Helper.softAssert();
	AboutUsPage aboutUs;
	SearchPage seachPage;
	UserPage userPge;
	public static String myAmberWindowId;

	@Before
	public void setUp() {
		driver = BrowserPage.getDriver();
		homePage = new HomePage(driver);
		featuePage = new FeaturePage(driver);
		aboutUs = new AboutUsPage(driver);
		seachPage = new SearchPage(driver);
		userPge = new UserPage(driver);

	}

	@After
	public void tearDown() {
//		BrowserPage.quitDriver();
	}

	@Given("User opens Chrome browser and navaigate to {string}")
	public void user_opens_chrome_browser_and_navaigate_to(String url) {
		driver.get(url);
	}

	@When("User scrolls down to Survivor Toolkit section")
	public void user_scrolls_down_to_survivor_toolkit_section() {
		homePage.skipGuide();
	}

	@When("User clicks on SOS Pages")
	public void user_clicks_on_sos_pages() {
		homePage.sosButton();
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/category/sos-page", "Both are Matched");

		driver.navigate().back();
	}

	@When("User clicks on Learning about your emotions and responses")
	public void user_clicks_on_learning_about_your_emotions_and_responses() {

		homePage.learningEmotions();
		softAssrt.assertEquals(driver.getCurrentUrl(),
				"https://www.myambar.org/category/learning-about-your-emotions-and-responses");
		driver.navigate().back();

	}

	@When("User click on Healthcare and Medical Testing")
	public void user_click_on_healthcare_and_medical_testing() {
		homePage.healthCare();
		softAssrt.assertEquals(driver.getCurrentUrl(),
				"https://www.myambar.org/category/healthcare-and-medical-testing");
		driver.navigate().back();
	}

	@When("User click Access to legal and judicial forums")
	public void user_click_access_to_legal_and_judicial_forums() {

		homePage.accessToLeagal();
		softAssrt.assertEquals(driver.getCurrentUrl(),
				"https://www.myambar.org/category/access-to-legal-and-judicial-forums");
		driver.navigate().back();
	}

	@When("User click Self-Care Toolbox")
	public void user_click_self_care_toolbox() {
		homePage.selfCareToolbox();
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/category/self-care-toolbox");
		driver.navigate().back();
	}

	@When("User click Empowered Voices")
	public void user_click_empowered_voices() {
		homePage.empoweredVoice();
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/category/empowered-voices");
		driver.navigate().back();
	}

	@When("User click Standing with Survivors")
	public void user_click_standing_with_survivors() {
		homePage.stadingSupviosr();
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/category/standing-with-survivors");
		driver.navigate().back();
	}

	@When("User click directory")
	public void user_click_directory() {
		homePage.directory();
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/directory");
		driver.navigate().back();
		softAssrt.assertAll();
	}
	// Below is the methods of Featue Screen

	@When("User clicks on Feature from the top header")
	public void user_clicks_on_feature_from_the_top_header() {
		featuePage.featureHeader();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/features");

	}

	@Then("User clicks on East for All")
	public void user_clicks_on_east_for_all() {

		softAssrt.assertEquals(featuePage.easeOfAll(), "Information that everybody can access and understand");

	}

	@Then("User clicks on Emergency SOS")
	public void user_clicks_on_emergency_sos() {
		softAssrt.assertEquals(featuePage.emergencySOS(),
				"Instantly inform your contacts when you need urgent assistance");

	}

	@Then("User clicks on Risk Assessment")
	public void user_clicks_on_risk_assessment() {

		softAssrt.assertEquals(featuePage.riskAssesment(), "Identify your risks with a self assessment test");
	}

	@Then("User clicks on Local Support")
	public void user_clicks_on_local_support() {
		softAssrt.assertEquals(featuePage.localSuppot(), "Find Support that is within your reach");
		softAssrt.assertAll();
	}

	@When("User scrolls down to the Google Play section")
	public void user_scrolls_down_to_the_google_play_section() {

		featuePage.scrollDownOnScreen();
		String windowId = driver.getWindowHandle();
		myAmberWindowId = windowId;
	}

	@When("User clicks on the Google Play button")
	public void user_clicks_on_the_google_play_button() {
		softAssrt.assertEquals(featuePage.googlePlayRedirection(),
				"https://play.google.com/store/apps/details?id=com.app.myambar");
		driver.close();

		driver.switchTo().window(myAmberWindowId);
		// driver.close();
	}

	@When("User clicks on About Us from the top header")
	public void user_clicks_on_about_us_from_the_top_header() {
		aboutUs.clickOnAboutUs();

	}

	@Then("User should see content related to About Us")
	public void user_should_see_content_related_to_about_us() {
		softAssrt.assertEquals(aboutUs.confirmURL(), "https://www.myambar.org/about-us");
	}

//	@When("User clicks on the Search button searches for {string} text")
//	public void user_clicks_on_the_search_button_searches_for_text(String searchTxt) throws InterruptedException {
//
//		softAssrt.assertEquals(seachPge.search(searchTxt), " No result found. ");
//		driver.navigate().refresh();
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//	}
//
//	@When("User clicks on the Search button searches for {string}")
//	public void user_clicks_on_the_search_button_searches_for(String searchTxt) {
//		softAssrt.assertEquals(seachPge.search(searchTxt), " Result found. ");
//	}

	// Below are the step defination for AfteLoginFlow

	@Given("User clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.navigate().to("https://www.myambar.org/");
		homePage.skipGuide();
		homePage.login();

	}

	@When("User logs in using Facebook with {string} and password {string}")
	public void user_logs_in_using_facebook_with_and_password(String email, String pwd) {

		homePage.clickGoogle(email, pwd);

	}

	@Then("User should be redirected to the Dashboard")
	public void user_should_be_redirected_to_the_dashboard() {
		softAssrt.assertEquals(driver.getCurrentUrl(), "https://www.myambar.org/user/dashboard");
		softAssrt.assertAll();
	}

	@When("User clicks on Update Profile button")
	public void user_clicks_on_update_profile_button() {
		userPge.updateProfile();

	}

	@When("User updates name and other fields")
	public void user_updates_name_and_other_fields(String name) {

		softAssrt.assertEquals(userPge.myProfile(name), " User updated successfully ");

	}


	@Given("User navigates to Am I at Risk? section")
	public void user_navigates_to_am_i_at_risk_section() {
		userPge.amIAtRrisk();
	}

//	@When("User selects Yes or No randomly for each question")
//	public void user_selects_yes_or_no_randomly_for_each_question() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on Submit button")
//	public void user_clicks_on_submit_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Confirmation message should be displayed")
//	public void confirmation_message_should_be_displayed() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}


	@Given("User navigates to the Emergency section")
	public void user_navigates_to_the_emergency_section(String name) {
	   userPge.clickEmgContacts();
	}

	@When("User adds name & number in the contact field")
	public void user_adds_name_number_in_the_contact_field(String name, String num) {
		userPge.addContact(name, num);
	}

	@When("User clicks on the + icon")
	public void user_clicks_on_the_icon() {
		userPge.clickOnPlus();
	}

	@Then("The number should be added successfully")
	public void the_number_should_be_added_successfully() { 
		softAssrt.assertEquals(driver.findElements(By.xpath("//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")).getFirst(), " User contacts added successfully ");
		softAssrt.assertAll();
	}

	@When("User click on edit icon and update the infomation")
	public void user_click_on_edit_icon_and_update_the_infomation(String name) {
	   userPge.clickEditIcon(name);	
	}

	@Then("The contact should be updated successfully")
	public void the_contact_should_be_updated_successfully() {
		softAssrt.assertEquals(driver.findElements(By.xpath("//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")).getFirst(), " User contact updated successfully ");
		softAssrt.assertAll();	
	}

	@When("User deletes the contact")
	public void user_deletes_the_contact() {
		userPge.delete();
		
	}

	@Then("The contact should be removed successfully")
	public void the_contact_should_be_removed_successfully() {
	
		softAssrt.assertEquals(driver.findElements(By.xpath("//div[@class='overlay-container']"))," User contact deleted successfully ");
	}

	@Given("User navigates to the Directory section")
	public void user_navigates_to_the_directory_section() {

		userPge.directorySection();
		softAssrt.assertEquals(driver.getCurrentUrl(),"https://www.myambar.org/user/directory");
	}

	@When("User searches for Chandigarh")
	public void user_searches_for_chandigarh(String city) {
		
		softAssrt.assertEquals(userPge.searchArea(city) , " Service provider listing " );
	}
}
//	@Then("User should see content under the Emergency Resources section")
//	public void user_should_see_content_under_the_emergency_resources_section() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("User scrolls to the Footer section")
//	public void user_scrolls_to_the_footer_section() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on About Us link")
//	public void user_clicks_on_about_us_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on Feature link")
//	public void user_clicks_on_feature_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on How to Use link")
//	public void user_clicks_on_how_to_use_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("A popup should be displayed")
//	public void a_popup_should_be_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User clicks Next until Okay, Got It button appears")
//	public void user_clicks_next_until_okay_got_it_button_appears() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on Privacy Policy link")
//	public void user_clicks_on_privacy_policy_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on Terms and Conditions link")
//	public void user_clicks_on_terms_and_conditions_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on Twitter icon")
//	public void user_clicks_on_twitter_icon() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	
//	
//}
