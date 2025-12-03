package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int EXPLICITWAIT = 5;
public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
public void waitUntilElementToBeVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.visibilityOfElementLocated((By) element)); 
}

public void waitUntilAnAlertisPresent(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void waitUntilElementsTobeSelectable(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void waitUntilTextAppearsInsideanElement(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.textToBePresentInElement(element, null)); 
}
public void waitUntilFrameIsAvailableAndSwitchToIt(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)); 
}
}
