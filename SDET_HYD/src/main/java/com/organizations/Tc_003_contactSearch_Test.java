package com.organizations;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Set;
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

	public class Tc_003_contactSearch_Test {
		WebDriver driver;

		@Test
		public void CreateContactTestWindowHandle() throws InterruptedException, IOException {
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

			String b1 = wb.getSheet("Sheet2").getRow(0).getCell(0).toString();
			WebElement First = driver.findElement(By.name("salutationtype"));
			Select Firstdd = new Select(First);
			Firstdd.selectByValue(b1);
			
			String b2 = wb.getSheet("Sheet2").getRow(0).getCell(2).toString();
			String b3 = wb.getSheet("Sheet2").getRow(0).getCell(3).toString();
			driver.findElement(By.name("lastname")).sendKeys(b2);
			driver.findElement(By.id("mobile")).sendKeys(b3);

			//Window Handling
			WebElement img = driver.findElement(By.xpath("(//img[@title='Select'])[1]"));
			img.click();

			Set<String> windows = driver.getWindowHandles();
			Iterator<String> window = windows.iterator();

			String parentWindow = window.next();
			String childWindow = window.next();

			driver.switchTo().window(childWindow);

			driver.findElement(By.id("search_txt")).sendKeys(wb.getSheet("Sheet2").getRow(0).getCell(4).toString());

			driver.findElement(By.name("search")).click();

			driver.findElement(By.xpath("//a[@id='1' and text()='" + wb.getSheet("Sheet2").getRow(0).getCell(4) + "']"))
			.click();

			driver.switchTo().window(parentWindow);

			String img2 = wb.getSheet("Sheet2").getRow(0).getCell(1).toString();
			WebElement Leadsource = driver.findElement(By.name("leadsource"));
			Select Lead = new Select(Leadsource);
			Lead.selectByValue(img2);

			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

			Thread.sleep(4000);

					driver.close();

	}}




