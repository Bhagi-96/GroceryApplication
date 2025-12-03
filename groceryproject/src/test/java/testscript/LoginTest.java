package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities; 





public class LoginTest extends Base {
	
	HomePage home; 
	
	@Test (priority = 1, description = "User is trying to login with valid credentials",groups= {"smoke"})
	
	public void verifyLoginsWithValidCredentials() throws IOException {
		
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue);
		
		home = loginpage.signinField(); 
		Boolean adminuserdisplayed = loginpage.adminUserIspresentorNot();
		Assert.assertTrue(adminuserdisplayed,Constant.VALIDCREDENTIALERROR); 
		
	}
	@Test (priority = 2,retryAnalyzer=retry.Retry.class, description = "user is trying to login with invalid username valid password")
	public void verifyLoginWithInvalidUsernameandValidPassword() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(1, 0,"login"); 
		String passwordvalue = ExcelUtilities.getStringData(1, 1,"login"); 
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue).signinField(); 
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAMEANDVALIDPASSWORDERROR); 
	}
	@Test (priority = 3, description = "user is trying to login with valid username and invalid password")
	public void verifyLoginWithInvalidPasswordAndValidUsername() throws IOException { 
		String usernamevalue = ExcelUtilities.getStringData(2, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(2, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue).signinField(); 
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.VALIDUSERNAMEANDINVALIDPASSWORD); 
	}
	@Test (priority = 4, description  = "user is trying to login with invalid credentials",groups= {"smoke"},dataProvider = "loginProvider" )
	public void verifyLoginWithInvalidCredentials(String usernamevalue,String passwordvalue ) throws IOException {
		//String usernamevalue = ExcelUtilities.getStringData(3, 0,"login");
		//String passwordvalue = ExcelUtilities.getStringData(3, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue).signinField();
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALS); 
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	} 
	

}
