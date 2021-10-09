package com.organizations;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class Tc_002_contact_Test {
		WebDriver driver;

		@Test
		public void CreatecontactTest() throws InterruptedException, IOException {

			FileInputStream fis = new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDETHyderabad\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(fis);

			FileInputStream fs = new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDET_HYD\\SDET_HYD\\data\\datadriven.xlsx");
			Workbook wb = WorkbookFactory.create(fs);

			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				driver = new ChromeDriver();
				System.out.println("chrome is opened");
			} else if (browsername.equals("firefox")) {

			} else {
				System.out.println("please enter proper browser name");
			}
			driver.get(prop.getProperty("url"));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			String a1 = wb.getSheet("Sheet2").getRow(0).getCell(0).toString();
			WebElement First = driver.findElement(By.name("salutationtype"));
			Select Firstdd = new Select(First);
			Firstdd.selectByValue(a1);

			Random random = new Random();
			int randomnumber = random.nextInt(1000);
			System.out.println(randomnumber);

			String a2 = wb.getSheet("Sheet2").getRow(0).getCell(2).toString();
			String a3 = wb.getSheet("Sheet2").getRow(0).getCell(3).toString();
			driver.findElement(By.name("lastname")).sendKeys(a2);
			driver.findElement(By.id("mobile")).sendKeys(a3);

			String a4 = wb.getSheet("Sheet2").getRow(0).getCell(1).toString();
			WebElement Leadsource = driver.findElement(By.name("leadsource"));
			Select Lead = new Select(Leadsource);
			Lead.selectByValue(a4);

			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

			Thread.sleep(4000);

		/*	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(a4);
			String a3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
			WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
			Select Indd = new Select(Indropdown);
			Indd.selectByVisibleText(a3);

			driver.findElement(By.xpath("//input[@name='submit']")).click();

			WebElement contactname = driver
					.findElement(By.xpath("//a[@title='Contacts' and text()='" + a4+ "']"));

			if (contactname.isDisplayed()) {
				Assert.assertTrue(true);
			}

			driver.close();

		}*/
driver.close();
	}}




