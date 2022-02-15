package com.example.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex03 {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
			Thread.sleep(2000);
			
			WebElement searchBox = driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button"));
			searchBox.click();
			String Handle = driver.getWindowHandle();
			searchBox = driver.findElement(By.cssSelector("#menu_1 > a"));
			searchBox.click();
			
			String newHandle = null;
			for (String id : driver.getWindowHandles()) {
				if (!id.equals(Handle)) {
					newHandle = id;
				}
			}
			driver.switchTo().window(newHandle);
			
			searchBox = driver.findElement(By.cssSelector("#topMenuBtn03"));
			searchBox.click();
			
			
			searchBox = driver.findElement(By.name("StartDateYY"));
			searchBox.sendKeys("4");
			searchBox = driver.findElement(By.name("StartDateMM"));
			searchBox.sendKeys("2");
			searchBox = driver.findElement(By.name("StartDateDD"));
			searchBox.sendKeys("15");
			
			searchBox = driver.findElement(By.name("EndDateYY"));
			searchBox.sendKeys("4");
			searchBox = driver.findElement(By.name("EndDateMM"));
			searchBox.sendKeys("3");
			searchBox = driver.findElement(By.name("EndDateDD"));
			searchBox.sendKeys("15");
			
			Thread.sleep(2000);
			
			searchBox = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
			searchBox.click();
			
			int row = driver.findElement(By.cssSelector("body > div.contents > div > form > table.list-data > tbody")).findElements(By.tagName("tr")).size();
			
			
			for(int i = 2; i <= row; i++) {
                String cssSelector = "body > div.contents > div > form > table.list-data > tbody";
                String index = String.valueOf(i);
                String cp = cssSelector + " > tr:nth-child(" + index + ")";
                String replace = "";
                
                for(int j = 1; j <= 3; j++) {
                    String cpa = "";
                    String text = "";
                    String index2 = String.valueOf(j);
                    replace = cp;
                    cpa = replace + " > td:nth-child(" + index2 + ")";

                    text = driver.findElement(By.cssSelector(cpa)).getText();
                    
                    if(j < 3) {
                    	System.out.print(text + ",");
                    } else {
                    	System.out.print(text);
                    }
                }
                System.out.println();
            }
			
			Thread.sleep(2000);
			driver.quit();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
