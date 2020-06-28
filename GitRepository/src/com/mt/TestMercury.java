package com.mt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMercury
{
	public WebDriver driver;

	@BeforeSuite
	public void openBrowser()
	{
		System.out.println("Under BeforeSuite");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sandip\\Desktop\\selenium-java-3.141.59\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Browser Successfully open");
	}

	
	@BeforeTest
	public void enterUrl()
	{
		System.out.println("Under Before Test");
		driver.get("http://newtours.demoaut.com/");
	}

	@BeforeClass
	public void maximizeWindow()
	{
		System.out.println("Under Before  class");
		driver.manage().window().maximize();
		System.out.println("succesfully maximize window");
	}

	@BeforeMethod
	public void getCookies()
	{
		System.out.println("Under Before Method");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies)
		{
			System.out.println("cookie name " + cookie.getName()); // osCsid
		}
	}

	
	@Test()
	public void loginWithValidUser()
	{
		System.out.println("Enter valid information of user");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("san");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("san");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		System.out.println("Succesfull Login");
	}

	@AfterTest
	public void captureScreen() throws IOException
	{
		System.out.println("Under After Method");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\san.bmp"));
		System.out.println("successfully ScreenShot");

	}

	@AfterClass
	public void deleteCookies()
	{
		System.out.println("Under after Class");
		driver.manage().deleteAllCookies();
		System.out.println("succesfullly delete cookies");
	}

	@AfterTest
	public void dbConnectionClosed()
	{
		System.out.println("under After Test");
		System.out.println("Db connection is closed");
	}

	@AfterSuite
	public void closeBrowser()
	{
		System.out.println("under After Test");
		//driver.close();
	}

	

}
