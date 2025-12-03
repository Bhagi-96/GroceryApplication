package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility page = new PageUtility();
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//a[text()=' New']") WebElement newuser; 
@FindBy(xpath="//input[@id='username']") WebElement adminusername;
@FindBy(xpath="//input[@id='password'] ")WebElement adminpassword;
@FindBy(xpath="//select[@id='user_type'] ")WebElement usertype; 
@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Create']")WebElement save;
@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement search;
@FindBy(xpath="//input[@id='un']")WebElement searchadminuser;
@FindBy(xpath="//select[@id='ut']  ")WebElement selectusertype;
@FindBy(xpath="//button[@name='Search']") WebElement clicksearch;
@FindBy(xpath="//a[text()=' Reset'] ")WebElement reset;
@FindBy(xpath="//h1[text()='Admin Users'] ")WebElement adminuser;
public AdminUserPage newUser() {
	newuser.click();
	return this;
}
public AdminUserPage enterAdminUserName(String adminusernamevalue) {
	adminusername.sendKeys(adminusernamevalue);
	return this;
}
public AdminUserPage enterAdminPassword(String adminpasswordvalue) {
	adminpassword.sendKeys(adminpasswordvalue);
	return this; 
}
public AdminUserPage selectUserType() {
	page.selectDropDownWithIndex(usertype, 3); 
	return this;
	//Select s = new Select(usertype); 
	//s.selectByIndex(3); 
}
public AdminUserPage clickSelect() {
	save.click();
	return this; 
}
public AdminUserPage clickSearch() {
	search.click();
	return this; 
}
public AdminUserPage searchAdminUsername(String searchusernamevalue) {
	searchadminuser.sendKeys(searchusernamevalue); 
	return this;
}
public AdminUserPage selectUserType1() {
	page.selectDropDownWithVisibleText(selectusertype, "Staff");
	return this; 
	//Select s = new Select(selectusertype); 
	//s.selectByVisibleText("Staff"); 
}
public AdminUserPage clickSearch1() {
	clicksearch.click();
	return this; 
	
}
public AdminUserPage clickResetButton() {
	reset.click();
	return this; 
}
public String isTitleDisplayed() {
	return adminuser.getText(); 
	
}
}

