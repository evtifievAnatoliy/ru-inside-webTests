package ru.inside.webTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new RecordTread();
		thread.start();
		
		
	}
	
	public static class RecordTread extends Thread{
		@Override
		public void run() {
			System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			try {
				
				logger.info("Test: ");
				driver.get("https://gorzdrav.spb.ru/service-free-schedule#%5B%7B%22district%22%3A4%7D%5D");
				
				List<WebElement> districtInputElementList = driver.findElements(By.className("service-districts-list__item"));
				
				WebElement districtInputElement = districtInputElementList.get(4); 
				districtInputElement.click();
				
				//WebElement districtInputElement = districtInputElementList.get(4); 
				//Select select = new Select(districtInputElement);
			    //select.selectByIndex("Калининский");
				//districtInputElement.click();
			
				TimeUnit.SECONDS.sleep(1);
			
//				inputElement.submit();
			} catch (InterruptedException e) {
				logger.info("False: " + e.getMessage());
			}
			finally {
				//driver.quit();
			}
			
		}
		
	}
}
