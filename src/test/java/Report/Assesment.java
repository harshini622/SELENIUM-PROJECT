package Report;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Assesment {

	ChromeDriver driver;
	@BeforeMethod
	public void setUp() {
	driver = new ChromeDriver();
	driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters("browsers")
	@Test
	public void login() {
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
	driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Dashboard']")).isDisplayed(),true);
	}
	
	@Parameters("browsers")
	@Test
	public void adminPart() {
	driver.findElement(By.xpath("//a//b[text()='Admin']")).click();
	Assert.assertTrue(driver.getCurrentUrl().contains("User Management"));
	Assert.assertTrue(driver.getCurrentUrl().contains("Add User"));
	}
	
	@Parameters("browsers")
	@Test
	public void userAdd() {
	driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
	Assert.assertTrue(driver.getCurrentUrl().contains("Add User"));
	}

	@Parameters("browsers")
	@Test
	public void addingUser() throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
	driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Harshi");
	driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Harshi@123");
	driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Harshi@123");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='btnSave']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@id='welcome']")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Assert.assertTrue(driver.getCurrentUrl().contains("LOGIN Panel"));
	}
	
	@Parameters("browsers")
	@Test
	public void loginInvalid() throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Harshi");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Harshi@123");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Dashboard']")).isDisplayed(),true);
}
}
