package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtilities;

public class ManageNewsTest extends Base {
	ManageNewsPage newspage;
	HomePage homepage; 
	@Test (description = "user is trying to add new news") 
	public void userIsAbleToAddNewNews() throws IOException {  
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
		
		homepage = loginpage.signinField();
		
		newspage = homepage.clickManageNewsMoreInfo(); 
		
		 
		String news = ExcelUtilities.getStringData(0, 0,"ManageNews");
		newspage.clickNewButton().enterNews(news).clickSaveButton(); 
		
		Boolean newbuttondisplayed = newspage.isNewButtonIsDisplayed();
		Assert.assertEquals(newbuttondisplayed,Constant.ADDNEWNEWSERROR); 
		
		
		//String actual = "Manage News";
		//String expected = newspage.isTitleDisplayed();
		
		//Assert.assertEquals(actual, expected,Constant.ADDNEWNEWSERROR);  
		
		
	}
	@Test (description = "user is trying to search news")
	public void userIsAbleToSeachNews() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
		
		homepage = loginpage.signinField();
		
		newspage = homepage.clickManageNewsMoreInfo(); 
		
		
		String newssearch = ExcelUtilities.getStringData(1, 0,"ManageNews");
		newspage.clickSearchButton().searchNews(newssearch).searchButtonClick(); 
		String actual = "Manage News";
		String expected = newspage.isTitleDisplayed();
		
		Assert.assertEquals(actual, expected,Constant.SEARCHNEWSERROR); 
		
	}
	@Test ( description = "user is trying to reset manage news page")
	
	public void userIsAbleToResetManageNewsPage() throws IOException { 
		String usernamevalue = ExcelUtilities.getStringData(0, 0,"login");
		String passwordvalue = ExcelUtilities.getStringData(0, 1,"login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.userNameField(usernamevalue).passwordField(passwordvalue); 
		
		homepage = loginpage.signinField();
		
		newspage = homepage.clickManageNewsMoreInfo();
		
		newspage.clickResetButton(); 
		String actual = "Manage News";
		String expected = newspage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.MANAGENEWSPAGERESETERROR); 
		
	}

}
