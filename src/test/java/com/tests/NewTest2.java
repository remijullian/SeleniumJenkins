package com.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewTest2{
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.manage().window().maximize();
	}

	@Test
	public void newTourstest()
	{
		driver.findElement(By.name("userName")).sendKeys("remi");
		String text = driver.findElement(By.name("userName")).getAttribute("value");
		System.out.println("The Username entered is: "+text);
		driver.findElement(By.name("password")).sendKeys("remi");
		driver.findElement(By.name("login")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
