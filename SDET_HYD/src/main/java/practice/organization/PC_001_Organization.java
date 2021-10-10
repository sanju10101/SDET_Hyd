package practice.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PC_001_Organization {
	WebDriver driver;
	@Test
	public void practiceOrganization() throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDET_HYD\\SDET_HYD\\src\\main\\resources\\config.properties");
	    Properties prop=new Properties();
	     prop.load(fis);
	FileInputStream fs=new FileInputStream("C:\\Users\\MY-PC.DESKTOP-CB3S4U6\\automationz\\SDET_HYD\\SDET_HYD\\data\\datadriven.xlsx");
	Workbook wb=WorkbookFactory.create(fs);
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		driver=new ChromeDriver();
		System.out.println("Google chrome is opened");
	}else if (browsername.equals("firefox")) {
} 
	else {
		System.out.println("please enter proper browser name");
	}
	driver.get(prop.getProperty("url"));
	driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    Random r=new Random();
    int randomno=r.nextInt();
	System.out.println(randomno);
	String a1 = wb.getSheet("Sheet1").getRow(3).getCell(0).toString();
	String orgname=a1+randomno;
	System.out.println(orgname);
	String a2=wb.getSheet("Sheet1").getRow(3).getCell(1).toString();
	driver.findElement(By.id("tickersymbol")).sendKeys(a2);
	String a3=wb.getSheet("Sheet1").getRow(3).getCell(2).toString();
	driver.findElement(By.name("employees")).sendKeys(a3);
	String a4=wb.getSheet("Sheet1").getRow(3).getCell(3).toString();
    WebElement ratingdd=driver.findElement(By.xpath("//td/..//select[@name='rating']"));
    Select sel= new Select(ratingdd);
    sel.selectByValue(a4);
	driver.findElement(By.name("button")).click();
	}
}
