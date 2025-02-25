package Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.testng.asserts.SoftAssert;

import PageObject.BrowserPage;

public class Helper {

	WebDriver driver;
	public static JavascriptExecutor js;

	// Method for taking the softAssert
	public static SoftAssert softAssert() {

		return new SoftAssert();
	}

	// Method for taking the screenshot
	public static void captureScreenshot(WebDriver driver, String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("screenshots/" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void JavascriptExecutor()
	{
		
		 js = (JavascriptExecutor) driver;
	}

}
