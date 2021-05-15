package ru.inside.webTests.commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class testElementOnClick {

	public static void elementOnClick (String elementName, String xPath, Logger logger, WebDriver driver) {
		
		try {
			WebElement element = driver.findElement(By.xpath(xPath));
			element.click();
			logger.info("Test with element: " + elementName  + ": TRUE");
			TimeUnit.SECONDS.sleep(3);
			driver.navigate().back();
		} catch (NoSuchElementException e) {
			logger.info("Test with element: " + elementName  +": FALSE." + " NoSuchElementException" + e.getMessage());
		} catch (InterruptedException e) {
			logger.info("Test with element: " + elementName  +": FALSE." + " InterruptedException" + e.getMessage());
		}
		
	}
	
}
