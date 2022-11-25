package Report;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;

public class SmokeTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	
	@Test
	private void loginValid() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%\r\n");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		
	}
}
