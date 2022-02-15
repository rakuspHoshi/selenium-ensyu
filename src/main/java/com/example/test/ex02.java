package com.example.test;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ex02 {

	public static void main(String[] args) {
		
			try {
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://rakuplus.jp/wp-login.php?redirect_to=https%3A%2F%2Frakuplus.jp%2F&reauth=1");
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.name("log"));
				searchBox.sendKeys("ユーザー名");
				WebElement searchBox2 = driver.findElement(By.name("pwd"));
				searchBox2.sendKeys("パスワード");
				driver.findElement(By.name("wp-submit"));
				searchBox.submit();
				
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'k'時'mm'分'ss'秒'");
				try {
					Files.copy(file.toPath(), new File("保存先" + "スクリーンキャプチャ" + sdf.format(date) + ".png").toPath());					
				} catch (Exception e) {
				}
				System.out.println(file);
				
				Thread.sleep(5000);
				driver.quit();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

	}

}
