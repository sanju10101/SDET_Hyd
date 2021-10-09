package com.organizations;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;
	import java.util.stream.LongStream;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	
	public class Tc_001_OrganizationTest
	{
            WebDriver driver;
            @Test
		public void TCcreateorganisation() throws InterruptedException, Throwable {

			FileInputStream fis = new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDET_HYD\\SDET_HYD\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(fis);

			FileInputStream fss = new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDET_HYD\\SDET_HYD\\data\\datadriven.xlsx");
			Workbook wb = WorkbookFactory.create(fss);

			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				driver = new ChromeDriver();
				System.out.println("chrome is opened");
			} else if (browsername.equals("firefox")) {

			} else {
				System.out.println("please enter proper browser name");
			}
			driver.get(prop.getProperty("url"));

			String a1 = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.xpath("//a[text()='Organizations']")).click();

			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			Random random = new Random();
			int randomnumber = random.nextInt(1000);
			System.out.println(randomnumber);
			String organisationname = a1 + randomnumber;
			driver.findElement(By.name("accountname")).sendKeys(organisationname);
			
			String a2 = wb.getSheet("Sheet1").getRow(0).getCell(1).toString();
			WebElement IndustryDropdown = driver.findElement(By.name("industry"));
			Select industrydd = new Select(IndustryDropdown);
			industrydd.selectByVisibleText(a2);
			
			String a3 = wb.getSheet("Sheet1").getRow(0).getCell(2).toString();
			WebElement RatingDropDown = driver.findElement(By.name("rating"));
			Select ratingdd = new Select(RatingDropDown);
			ratingdd.selectByValue(a3);

			WebElement TypeDropDown = driver.findElement(By.name("accounttype"));
			Select typedd = new Select(TypeDropDown);
			typedd.selectByIndex(3);

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//a[text()='Organizations']")).click();

			driver.findElement(By.name("search_text")).sendKeys(organisationname);
			String a4 = wb.getSheet("Sheet1").getRow(0).getCell(3).toString();
			WebElement searchfldDropdown = driver.findElement(By.name("search_field"));
			
			Select searchdd = new Select(searchfldDropdown);
			searchdd.selectByVisibleText(a4);

			driver.findElement(By.name("submit")).click();

			WebElement organisationnames = driver.findElement(By.xpath("//a[@title='Organizations' and text()= '" + organisationname + "']"));
			if (organisationnames.isDisplayed()) {
				Assert.assertTrue(true);
			}
			driver.close();

		}

	}





