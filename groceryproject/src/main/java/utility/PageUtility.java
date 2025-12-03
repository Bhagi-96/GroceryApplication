package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
		
	}
	
	public void selectDropDownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index); 
	}
	
	public void selectDropDownWithContainsVisibleText(WebElement element,String text) { 
		Select object = new Select(element);
		object.selectByContainsVisibleText(text); 
	}
	
	public void selectDropDownWithVisibleText(WebElement element,String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text); 
	}
	
	public void clickCheckBox(WebElement element) {
		element.click();
		
	}
	public void clickRadioButton(WebElement element) {
		element.click();
	}
	
	public void sendkeys(WebElement element) {
		element.sendKeys("hello"); 
	}
	public void getText(WebElement element) {
		element.getText();
	}


}
