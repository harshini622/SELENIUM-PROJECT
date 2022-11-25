package DAY4;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DdtExample {
	ChromeDriver driver;
	
	@BeforeMethod
	public void connect() {
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("https://ineuron-courses.vercel.app/login");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(dataProvider = "testdata")
	public void login(String email,String password) {
		WebElement username=driver.findElement(By.name("email1"));
		username.sendKeys(email);
		driver.findElement(By.id("password1")).sendKeys(password);
		driver.findElement(By.className("submit-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed(), true);
		System.out.println("test Excecuted "+email+ " "+password);

	}

	@DataProvider(name="testdata")
	public Object[][] dataValues() {
		Object [][]arr=new Object[4][2];
		arr[0][0]="sample9@gmail.com";
		arr[0][1]="Mukesh1234";
		arr[1][0]="samplemukesh@gmail.com";
		arr[1][1]="Mukesh1234";
		arr[2][0]="samplemukesh1@gmail.com";
        arr[2][1]="Mukesh1234";
        arr[3][0]="samplemukesh2@gmail.com";
        arr[3][1]="Mukesh1234";
		
		return arr;
	}
}

