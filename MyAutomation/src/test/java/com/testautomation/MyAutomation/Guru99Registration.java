package com.testautomation.MyAutomation;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

// Saving the file

public class Guru99Registration 
{
  
  public WebDriver  driver;
  String url = "https://demo.guru99.com/V4/";
  String driverPath = "C:\\Users\\jayud\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe";
  Sheet sh =null;


  
  @BeforeSuite
  public void beforeSuite() throws  IOException 
  {
	  
	  System.out.println("Before Suite executed!!");
	  System.setProperty("webdriver.chrome.driver",driverPath );
	  driver = new ChromeDriver();  
  } 

  @Ignore
  @BeforeClass
  public void ReadData() throws IOException
  {
	  
	  System.out.println("Before Class is executing!!!");
	  Workbook wb;
	  File file;
	  FileInputStream input;
	  
	  file = new File("C:\\Users\\jayud\\OneDrive\\Desktop\\Customer.xlsx");
	  input = new FileInputStream(file);
	  
	  wb = new XSSFWorkbook(input);

	  sh = wb.getSheet("Customer_Details");
	  int RowsCount = sh.getLastRowNum();
	  
	  
	  
	  System.out.println(RowsCount);
	  
	  for(int i=0; i<=RowsCount; i++)
	  {
		  Row row = sh.getRow(i);
		  for(int j=0; j<row.getLastCellNum(); j++)
		  {
			  System.out.println(row.getCell(j));

		  }
	  }
	  
	  wb.close();
  }
  
  @AfterSuite
  public void afterSuite()
  {
	  System.out.println("After Suite executed!!");
	  driver.close();
  }
  
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("Before Test executed!!");
	  driver.navigate().to(url);
	  driver.manage().window().maximize();  
	  
	  driver.findElement(By.name("uid")).sendKeys("mngr136913");
	  driver.findElement(By.name("password")).sendKeys("Omn@12");
	  driver.findElement(By.name("btnLogin")).click();
	  String value = driver.findElement(By.xpath("//td[@style=\"color: green\"]")).getText();
	  assertEquals(value, "Manger Id : mngr136913");

  }
  
  @Test
  public void Loign()
  {
	  System.out.println("Loign Test executed!!");
	  driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();
  }
  
  
  @Test
  public void Loign1()
  {
	  System.out.println("Loign Test executed!!");
  }
  
  
 }
 
