package practice.organization;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Pc_005_organization {
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
    WebElement addr=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    Actions ac=new Actions(driver);
    ac.moveToElement(addr).perform();
    driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
    String a5=wb.getSheet("Sheet1").getRow(3).getCell(4).toString();
    		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(a5);
    String a6=wb.getSheet("Sheet1").getRow(3).getCell(5).toString();
    	driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(a6);
    	 String a7=wb.getSheet("Sheet1").getRow(3).getCell(6).toString();
    	 driver.findElement(By.id("email1")).sendKeys(a7);
    	 driver.findElement(By.xpath("//select/descendant::option[@value='Biotechnology']")).click();//just for practicing xpath cases
    	 driver.findElement(By.xpath("//option[@value='Investor']/ancestor::select[@name='accounttype']")).click();
    	 driver.findElement(By.xpath("//input[@value='T']")).click();
    	driver.findElement(By.xpath("//select/descendant::option[text()='Support Group']/following-sibling::option[text()='Team Selling']")).click();
    	driver.findElement(By.xpath("//select/descendant::option[text()='Support Group']/preceding-sibling::option[text()='Marketing Group']")).click();
    	WebElement wh=driver.findElement(By.xpath("//img[@language='javascript']"));
    	wh.click();
    	Set<String>windows=driver.getWindowHandles();
    	Iterator<String>window=windows.iterator();
    	String parentwindow=window.next();
    	String childwindow=window.next();
    	driver.switchTo().window(childwindow);
    	String a8=wb.getSheet("Sheet1").getRow(3).getCell(7).toString();
    	driver.findElement(By.xpath("//td/descendant::input[@id='search_txt']")).sendKeys(a8);
    	driver.findElement(By.xpath("//table/descendant::tr[*]/..//td/descendant::a[text()='qspider107']")).click();
    	driver.switchTo().window(parentwindow);
    	String a9=wb.getSheet("Sheet1").getRow(3).getCell(8).toString();
    	driver.findElement(By.name("email2")).sendKeys(a9);
    driver.findElement(By.name("button")).click();
    
    
}
}

