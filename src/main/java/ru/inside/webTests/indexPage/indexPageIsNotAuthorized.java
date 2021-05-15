package ru.inside.webTests.indexPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import ru.inside.webTests.commons.testElementOnClick;

public class indexPageIsNotAuthorized {

		
	public static void elementsOnClickTests (Logger logger, WebDriver driver) throws InterruptedException {
	
		//time between tests in seconds
		int timeBetweenTests = 2;
		
		logger.info("Start indexPageIsNotAuthorized elementsOnClickTests.");
		
		// test href fast-exchange
		testElementOnClick.elementOnClick("href /fast-exchange", "//a[@href ='/fast-exchange']", logger, driver);
		
		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href trade"
		testElementOnClick.elementOnClick("href /trade", "//a[@href ='/trade']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href sing in"
		testElementOnClick.elementOnClick("href /sing in", "/html/body/div/div[1]/header/div/div[2]/div[1]/a[1]", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href  sing up"
		testElementOnClick.elementOnClick("href /sing up", "/html/body/div/div[1]/header/div/div[2]/div[1]/a[2]", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href language"
		try {
			WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[2]/div[1]/i[2]"));
			element.click();
			logger.info("Test with element: href /language: TRUE");
			TimeUnit.SECONDS.sleep(2);
			WebElement elementEn = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[2]/div[2]/ul/li[2]/span"));
			elementEn.click();
			logger.info("Test change language on English: TRUE");
			TimeUnit.SECONDS.sleep(2);
			WebElement elementRu = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[2]/div[2]/ul/li[1]/span"));
			elementRu.click();
			logger.info("Test change language on Russian: TRUE");
			
		} catch (NoSuchElementException e) {
			logger.info("Test with element: href /language: FALSE");
		}
		
		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href support"
		testElementOnClick.elementOnClick("href /support", "//a[@href ='/support']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href terms-use"
		testElementOnClick.elementOnClick("href /terms-use", "//a[@href ='/terms-use']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href privacy-policy"
		testElementOnClick.elementOnClick("href /privacy-policy", "//a[@href ='/privacy-policy']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href aml-policy"
		testElementOnClick.elementOnClick("href /aml-policy", "//a[@href ='/aml-policy']", logger, driver);
		
		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href footer__fast-exchange"
		testElementOnClick.elementOnClick("href footer__fast-exchange", "/html/body/div/footer/div/div[2]/ul/li[1]/a", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href footer__walet"
		testElementOnClick.elementOnClick("href footer__walet", "/html/body/div/footer/div/div[2]/ul/li[3]/a", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href comissions"
		testElementOnClick.elementOnClick("href comissions", "//a[@href ='/comissions']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href about"
		testElementOnClick.elementOnClick("href about", "//a[@href ='/about']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href contacts"
		testElementOnClick.elementOnClick("href contacts", "//a[@href ='/contacts']", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href VK"
		testElementOnClick.elementOnClick("href VK", "/html/body/div/footer/div/div[2]/div/a[1]/i", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href Instagram"
		testElementOnClick.elementOnClick("href Instagram", "/html/body/div/footer/div/div[2]/div/a[2]/i", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href Facebook"
		testElementOnClick.elementOnClick("href Facebook", "/html/body/div/footer/div/div[2]/div/a[3]/i", logger, driver);
		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href Twitter"
		testElementOnClick.elementOnClick("href Twitter", "/html/body/div/footer/div/div[2]/div/a[4]/i", logger, driver);

		TimeUnit.SECONDS.sleep(timeBetweenTests);
		
		// test href Telegram"
		testElementOnClick.elementOnClick("href Telegram", "/html/body/div/footer/div/div[2]/div/a[5]/i", logger, driver);
		
		logger.info("Finish indexPageIsNotAuthorized elementsOnClickTests.");
		
	}
	
}
