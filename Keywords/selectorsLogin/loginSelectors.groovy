package selectorsLogin
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


public class LoginSelectors {

	//Dynamic Selectors
	def public static dynamicXpathButton = {value1 ->  return '//input[@type="button" and @value ="'+value1+'"]'}
	def public static dynamicXpathInput = {value1 ->  return '//input[@name="'+value1+'"]'}
	def public static dynamicXpathText = {value1 -> return '//b[contains(text(), "'+value1+'")]'}


	public static TestObject getMyTestObject(String selectorType, String selectorValue) {
		TestObject to = new TestObject()
		to.addProperty(selectorType, ConditionType.EQUALS, selectorValue)
		return to
	}

	public static void login(String username, String password) {
		String idUser = 'username'
		String idPass = 'password'
		String idLoginButton = 'Test Login'

		WebUI.setText(getMyTestObject("xpath", dynamicXpathInput.call(idUser)), username)
		WebUI.setText(getMyTestObject("xpath", dynamicXpathInput.call(idPass)), password)
		WebUI.click(getMyTestObject("xpath", dynamicXpathButton.call(idLoginButton)))

	}

	public static void checkLogin(text){
		WebUI.verifyTextPresent(text, true)
	}
}