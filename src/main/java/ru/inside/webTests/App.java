package ru.inside.webTests;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.inside.webTests.indexPage.indexPageIsNotAuthorized;


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
			
			// set start time
			long start = System.currentTimeMillis();
			
			System.setProperty("webdriver.chrome.driver", WEB_DRIVER_STRING);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			WebDriver driver = new ChromeDriver(options);
			try {
				
				driver.get(URL_STRING);
				logger.info("Open: " + URL_STRING);
				TimeUnit.SECONDS.sleep(3);

				//test for indexPage
				indexPageIsNotAuthorized.elementsOnClickTests(logger, driver);
				
				
//				TimeUnit.SECONDS.sleep(2);
//				// test names of elements on index
//				try {
//					WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/ul/li[1]/a"));
//					element.getText();
//					logger.info("Test with href /Telegram: TRUE"+ element.getText());
//					TimeUnit.SECONDS.sleep(3);
//					driver.navigate().back();
//				} catch (NoSuchElementException e) {
//					logger.info("Test with  href /Telegram : FALSE");
//				}

				
			} catch (InterruptedException e) {
				logger.info("Test False: " + e.getMessage());
			}
			finally {
				driver.quit();
				
				// set finish time
				long finish = System.currentTimeMillis();
				long elapsed = finish - start;
		        SimpleDateFormat formating = new SimpleDateFormat("HH:mm:ss:SSS");
				logger.info("Tests take: " + TimeUnit.MILLISECONDS.toMinutes(elapsed) + " minute(s).");
			}
			
		}
		
	}
}
