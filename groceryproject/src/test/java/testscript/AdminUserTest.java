package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities;
import utility.Randomdatautility;

public class AdminUserTest extends Base 
{ 
	HomePage homepage;
	AdminUserPage adminuserpage; 
	
	
	@Test (description = "user is trying to add new user")
public void userIsAbletoAddNewUser() throws IOException {
	String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
	String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
	LoginPage loginpage = new LoginPage(driver);
	
	loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
	
	homepage = loginpage.signinField(); 
	
	adminuserpage = homepage.moreInfo(); 

	
	Randomdatautility randomutility = new Randomdatautility();
	String adminusernamevalue = randomutility.randomUsername();
    String adminpasswordvalue = randomutility.randomPassword(); 
	
	//String adminusernamevalue = ExcelUtilities.getStringData(0, 0, "adminuser");
	//String adminpasswordvalue = ExcelUtilities.getStringData(0, 1, "adminuser");
    adminuserpage.newUser().enterAdminUserName(adminusernamevalue).enterAdminPassword(adminpasswordvalue).selectUserType().clickSelect();
	String actual = "Admin Users";
	String expected = adminuserpage.isTitleDisplayed();
	Assert.assertEquals(actual, expected,Constant.ADDNEWUSERERROR); 
}
	@Test (description = "user is trying to search admin users")
	public void userIsaableToSearchNewlyAddUser() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
		
		homepage = loginpage.signinField();
		
		adminuserpage = homepage.moreInfo(); 
		
		
		String searchusernamevalue = ExcelUtilities.getStringData(1, 0,"adminuser" );
		adminuserpage.clickSearch().searchAdminUsername(searchusernamevalue).selectUserType1().clickSearch1(); 
		String actual = "Admin Users";
		String expected = adminuserpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.SEARCHADMINUSERERROR); 
	}
	@Test (description = "user is trying to reset admin user page")
	public void userIsAbletoReset() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
		
		homepage = loginpage.signinField();
		
		adminuserpage = homepage.moreInfo();
		
		adminuserpage.clickResetButton(); 
		String actual = "Admin Users";
		String expected = adminuserpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.RESETERROR); 
	}
}
