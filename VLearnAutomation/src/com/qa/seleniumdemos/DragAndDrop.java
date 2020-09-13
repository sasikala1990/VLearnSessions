package com.qa.seleniumdemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sasikala_m01\\Desktop\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(0);
		Actions ac= new Actions(driver);
		//ac.dragAndDrop(driver.findElement(By.xpath("//span[text()='Draggable 1']")), driver.findElement(By.id("mydropzone"))).build().perform();
		ac.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
		.release()
		.build()
		.perform();
		driver.quit();
	}

}
