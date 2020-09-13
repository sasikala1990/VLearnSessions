package com.qa.seleniumdemos;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sasikala_m01\\Desktop\\chromedriver.exe");	
		driver = new ChromeDriver(); //launch chrome
		
//		dynamicWaitImplicit();
//		staticWait();
//		dynamicWaitExplicit();
//		dynamicWaitFluent();
		
	}
	public static void staticWait() throws InterruptedException {

		driver.get("http://www.google.com");
		driver.manage().window().maximize();

		driver.navigate().to("http://www.flipkart.com");
		
		//back and forward buttons simulation:
//		driver.navigate().back();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		driver.navigate().forward();
		
		Thread.sleep(2000);

		driver.navigate().back();
		
		driver.navigate().refresh();

        
       
		driver.quit();
	}
	public static void dynamicWaitImplicit() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	public static void dynamicWaitExplicit() throws InterruptedException {
	driver.navigate().to("http://www.facebook.com");
	clickOn(driver.findElement(By.xpath("//*[@name='login']")), 20);//login button
//	driver.navigate().to("http://www.facebook.com");
//	Thread.sleep(5000);
	clickOn(driver.findElement(By.linkText("Forgotten password?")), 20); //create a page link
	Thread.sleep(5000);
	driver.quit();
	}

	public static void clickOn(WebElement locator, int timeout) {
	new WebDriverWait(driver, timeout).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(locator));
	locator.click();
	}
	public static void dynamicWaitFluent() throws InterruptedException {
		driver.navigate().to("http://www.facebook.com");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS) // this defines the total amount of time to wait for
			       .pollingEvery(30, TimeUnit.SECONDS) // this defines the polling frequency
			       .ignoring(NoSuchElementException.class); // this defines the exception to ignore 
			      WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver)  //in this method defined your own subjected conditions for which we need to wait for
			     { 
			    	 WebElement foo1=driver.findElement(By.linkText("Forgotten password?"));
			    	 if(foo1.isDisplayed())
			    		 return foo1;
			    	 else
			    		 return null;
			}});

			      foo.click();
			      Thread.sleep(5000);
		driver.quit();
		}


}
