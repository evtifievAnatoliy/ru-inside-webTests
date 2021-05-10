package ru.inside.webTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	private static String URL_STRING; 
	private static final String WEB_DRIVER_STRING = "chromedriver.exe";
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		try {
			URL_STRING = args[0];
			Thread thread = new RecordTread();
			thread.start();
		}
		catch (Exception e) {
			logger.error("Usage:\n" +
					"java app.java https://rover.ws/ \n" +
					"java app.java https://skade.cc/ \n" +
					"java app.java https://dev.skade.cc/ \n" +
					"java app.java https://dev2.skade.cc/ \n");
		}
		
	}
	
	public static class RecordTread extends Thread{
		@Override
		public void run() {
			System.setProperty("webdriver.chrome.driver", WEB_DRIVER_STRING);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			WebDriver driver = new ChromeDriver(options);
			try {
				
				driver.get(URL_STRING);
				logger.info("Open: " + URL_STRING);
				TimeUnit.SECONDS.sleep(3);

				// test href fast-exchange
				try {
					WebElement element = driver.findElement(By.xpath("//a[@href ='/fast-exchange']"));
					element.click();
					logger.info("Test with href /fast-exchange : TRUE");
					TimeUnit.SECONDS.sleep(3);
					driver.navigate().back();
				} catch (NoSuchElementException e) {
					logger.info("Test with  href /fast-exchange : FALSE");
				}
				
				
				TimeUnit.SECONDS.sleep(2);
				// test href trade"
				try {
					WebElement element = driver.findElement(By.xpath("//a[@href ='/trade']"));
					element.click();
					logger.info("Test with href /trade: TRUE");
					TimeUnit.SECONDS.sleep(3);
					driver.navigate().back();
				} catch (NoSuchElementException e) {
					logger.info("Test with  href /fast-exchange : FALSE");
				}

				TimeUnit.SECONDS.sleep(2);
				// test href sing in"
				try {
					WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[1]/a[1]"));
					element.click();
					logger.info("Test with href /sing in: TRUE");
					TimeUnit.SECONDS.sleep(3);
					driver.navigate().back();
				} catch (NoSuchElementException e) {
					logger.info("Test with  href /sing in : FALSE");
				}
				
				TimeUnit.SECONDS.sleep(2);
				// test href sing up"
				try {
					WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[1]/a[2]"));
					element.click();
					logger.info("Test with href /sing up: TRUE");
					TimeUnit.SECONDS.sleep(3);
					driver.navigate().back();
				} catch (NoSuchElementException e) {
					logger.info("Test with  href /sing up : FALSE");
				}
				
				TimeUnit.SECONDS.sleep(2);
				// test href language"
				try {
					WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/header/div/div[2]/div[2]/div[2]/ul"));
					element.click();
					logger.info("Test with href /language: TRUE");
					TimeUnit.SECONDS.sleep(3);
					driver.navigate().back();
				} catch (NoSuchElementException e) {
					logger.info("Test with  href /language: FALSE");
				}
			
			} catch (InterruptedException e) {
				logger.info("Test False: " + e.getMessage());
			}
			finally {
				driver.quit();
			}
			
		}
		
	}
}
