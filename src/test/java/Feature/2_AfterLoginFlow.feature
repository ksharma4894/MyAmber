Feature: Validate navigation, content, After Login

  Scenario: User logs in using social account and updates profile
    Given User clicks on Login button
    When User logs in using Facebook with "kuldeep@signitysolutions.com" and password "Signity@123"
    Then User should be redirected to the Dashboard
    #And User clicks on Skip button
    When User clicks on Update Profile button
    And User updates name and other fields "Kuldeep Verma"
   
  Scenario: User click Am I at Risk? assessment
    Given User navigates to Am I at Risk? section
    When User selects Yes or No randomly for each question
    And User clicks on Submit button
    Then Confirmation message should be displayed

  Scenario: User adds, updates, and deletes emergency contact
    Given User navigates to the Emergency section
    When User adds name "Amit" & number "9878978978" in the contact field
    And User clicks on the + icon
    Then The number should be added successfully
    When User click on edit icon "Rajan Kumar" and update the infomation
    Then The contact should be updated successfully
    When User deletes the contact
    Then The contact should be removed successfully

  Scenario: User searches directory for Chandigarh
    Given User navigates to the Directory section
    When User searches for "Chandigarh"
    Then User should see content under the Emergency Resources section
#
  #Scenario: User navigates through footer links
    #Given User scrolls to the Footer section
    #When User clicks on About Us link
    #And User clicks on Feature link
    #And User clicks on How to Use link
    #Then A popup should be displayed
    #And User clicks Next until Okay, Got It button appears
    #When User clicks on Privacy Policy link
    #When User clicks on Terms and Conditions link
    #When User clicks on Twitter icon
