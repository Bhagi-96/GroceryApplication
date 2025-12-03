package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {  // constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//a[normalize-space()='Admin']") WebElement admin;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement logout;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminuser;
	@FindBy(xpath="//b[text()='7rmart supermarket'] ")WebElement titletext; 
	
  @FindBy(xpath="//p[normalize-space()='Admin Users']/ancestor::div[contains(@class,'small-box')]//a[contains(@class,'small-box-footer')]")WebElement moreinfo;
	@FindBy(xpath="//p[normalize-space()='Manage News']/ancestor::div[contains(@class,'small-box')]//a[contains(@class,'small-box-footer')]")WebElement managenewsmoreinfo;

	
 public HomePage clickAdmin() { 
	 admin.click();
	 return this;
 }
 
public LoginPage clickLogOut()
{
	logout.click();
	return new LoginPage(driver); 
}
public boolean adminUserIspresentorNot() {
	 return adminuser.isDisplayed();
}
public String isTitleDisplayed() { 
	 return titletext.getText();
	 
}
public AdminUserPage moreInfo() {
	moreinfo.click();
	return new AdminUserPage(driver); 
}
public ManageNewsPage clickManageNewsMoreInfo() {
	managenewsmoreinfo.click();
	return new ManageNewsPage(driver); 
}
}
