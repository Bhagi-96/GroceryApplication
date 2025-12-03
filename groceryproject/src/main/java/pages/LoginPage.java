package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public LoginPage(WebDriver driver) {  // constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//input[@type='text']")WebElement username; 
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(xpath="//input[@type='checkbox']")WebElement rememberme;
	@FindBy(xpath ="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminuser;
	@FindBy(xpath="//b[text()='7rmart supermarket'] ")WebElement titletext; 
	
	 
	
	
	
 public LoginPage userNameField(String usernamevalue) { 
	 username.sendKeys(usernamevalue); 
	 return this;
	 
 }
 public LoginPage passwordField(String passwordvalue) {
	 password.sendKeys(passwordvalue);
	 return this; 
 }

 public HomePage signinField() {
	 wait.waitUntilElementToBeClickable(driver, signin);
	 signin.click();
	 return new HomePage(driver); 
 }
 public boolean adminUserIspresentorNot() {
	 return adminuser.isDisplayed();
 }
 public String isTitleDisplayed() { 
	 return titletext.getText();
	 
 }
}
