package testscript;

import java.io.IOException; 

import org.testng.Assert; 
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities;

public class HomeTest extends Base { 
	HomePage homepage; 
	@Test (description =" user is trying to logged out")
	public void userIsableToSuccessfullyLoggedOut() throws IOException {  
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue);  
		
		homepage = loginpage.signinField(); 
		
		homepage.clickAdmin();
		loginpage = homepage.clickLogOut(); 
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.LOGGEDOUTERROR); 
		
		
	}
}
	