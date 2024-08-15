import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open the browser
WebUI.openBrowser('')

// Navigate to the AlphaPay homepage
WebUI.navigateToUrl('https://alphapay.netlify.app/')

// Click on the "GET STARTED" button
WebUI.click(findTestObject('Object Repository/Page_alphapay  Home/button_GET STARTED'))

// Fill out the account creation form
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_full_name'), 'Irene Emeshili')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_username'), 'tester_Irene')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_phone_number'), '08108461380')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_email'), 'ireneemeshili@gmail.com')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_password_1'), 'Qwerty1234?!')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Create Account_confirmPassword'), 'Qwerty1234?!')

// Submit the account creation form
WebUI.click(findTestObject('Object Repository/Page_alphapay  Authentication/button_Create Account'))

// Wait for the account to be created
WebUI.delay(5)

// Navigate to the login page
WebUI.navigateToUrl('https://alphapay.netlify.app/auth/login')

// Log in with the newly created account
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Provide your email please_email'), 'ireneemeshili@gmail.com')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Authentication/input_Sign In_password'), 'Qwerty1234?!')
WebUI.click(findTestObject('Object Repository/Page_alphapay  Authentication/button_Sign In'))

// Wait for the dashboard to load
WebUI.delay(5)

// Navigate to the profile page
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/img'))
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/a_Profile'))

// Update the full name on the profile
WebUI.sendKeys(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Full Name_full_name'), Keys.chord(Keys.SHIFT, Keys.ARROW_UP))
WebUI.sendKeys(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Full Name_full_name'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Full Name_full_name'), 'Irene Eze')

// Update the username on the profile
WebUI.sendKeys(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Username_username'), Keys.chord(Keys.SHIFT, Keys.ARROW_UP))
WebUI.sendKeys(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Username_username'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Username_username'), 'Ms Irene')

// Submit the profile updates
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/button_Update Details'))

// Wait for the updates to be processed
WebUI.delay(5)

// Navigate to the security settings page
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/a_Security'))

// Change the password
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Log Out_password'), 'Qwerty1234?!')
WebUI.setText(findTestObject('Object Repository/Page_alphapay  Dashboard/input_Log Out_new_password'), 'Asdfgh1234567?!')
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/button_Change Password'))

// Wait for the password to be updated
WebUI.delay(5)

// Log out from the account
WebUI.click(findTestObject('Object Repository/Page_alphapay  Dashboard/a_Log Out'))

// Close the browser
WebUI.closeBrowser()

