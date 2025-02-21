Feature: Validate navigation, content, and search functionality on MyAmbar website as a Guest User

  Scenario: Verify content on homepage
    Given User opens Chrome browser and navaigate to "https://www.myambar.org/"
    When User scrolls down to Survivor Toolkit section
    And User clicks on SOS Pages
    And User clicks on Learning about your emotions and responses
		And User click on Healthcare and Medical Testing
		And User click Access to legal and judicial forums
		And User click Self-Care Toolbox
		And User click Empowered Voices
		And User click Standing with Survivors
		And User click directory


  Scenario: Verify Content on Feature Page
    When User clicks on Feature from the top header
    Then User clicks on East for All
    And User clicks on Emergency SOS
    And User clicks on Risk Assessment
    And User clicks on Local Support

  Scenario: Verify Google Play redirection on Feature Page
    When User scrolls down to the Google Play section
    And User clicks on the Google Play button
 
	Scenario: Verify About Us navigation
    When User clicks on About Us from the top header
    Then User should see content related to About Us

#	Scenario: Verify search functionality
    #When User clicks on the Search button searches for "MyAmbar" text
    #And User clicks on the Search button searches for "SOS Page"

