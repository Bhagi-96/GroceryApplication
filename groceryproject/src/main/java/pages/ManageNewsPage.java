package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()=' New']")WebElement newnews;
	@FindBy(xpath="//textarea[@id='news']")WebElement enternews;
	@FindBy(xpath="//button[@type='submit'] ")WebElement save;
	@FindBy(xpath="//a[text()=' Search']")WebElement search;
	@FindBy(xpath="//input[@type='text'] ")WebElement searchnews;
	@FindBy(xpath="//button[@name='Search']")WebElement clicksearch;
	@FindBy(xpath="//a[text()=' Reset']")WebElement reset;
	@FindBy(xpath="//h1[text()='Manage News'] ")WebElement managenewstitle; 
	@FindBy(xpath="//h4[text()='Manage News'] ")WebElement managenewstext; 
	 
	
	public ManageNewsPage clickNewButton() {
		newnews.click();
		return this;
	}
	public ManageNewsPage enterNews(String news) {  
		enternews.sendKeys(news);
		return this;  
		
	}
	
	public ManageNewsPage clickSaveButton() {
		save.click();
		return this; 
	}
	public ManageNewsPage clickSearchButton() {
		search.click();
		return this; 
	}
	public ManageNewsPage searchNews(String newssearch) {
		searchnews.sendKeys(newssearch);
		return this;
		
	}
	public ManageNewsPage searchButtonClick() {
		clicksearch.click();
		return this; 
	}
	public ManageNewsPage clickResetButton() {
		reset.click();
		return this; 
	}
	public String isTitleDisplayed() {
		return managenewstitle.getText(); 
		
	}
	
	public boolean isNewButtonIsDisplayed() {
		return newnews.isDisplayed(); 
	}
	
}
