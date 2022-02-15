package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01 {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.google.com/xhtml");
			Thread.sleep(5000);
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("selenium");
			searchBox.submit();
			System.out.println(driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div.NJo7tc.Z26q7c.jGGQ5e > div > a")).getText());
			Thread.sleep(5000);
			driver.quit();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
