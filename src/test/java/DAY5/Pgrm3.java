package DAY5;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Pgrm3 {
	WebDriver driver;
	
	@Parameters({"browserName","browserVersion","os","osVersion"})
	@BeforeMethod
	public void setup(String s1,String s2,String s3,String s4) {
	DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("browserName", s1);
		
		capabilities.setCapability("browserVersion", s2);
		
		capabilities.setCapability("os", s3);
		
		capabilities.setCapability("osVersion", s4);

		URL url= null;
		try {
			url= new URL("https://harshini_Cow4Fj:Ea1sFzZhrazzkMxxCKaW@hub-cloud.browserstack.com/wd/hub");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver=new RemoteWebDriver(url, capabilities);
	}

@AfterMethod
public void tearDown(){
	driver.quit();
}

@Test
public void urlLink() {
	driver.get("https://ineuron-courses.vercel.app/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ineuron@ineuron.ai");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ineuron");    
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    AssertJUnit.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed(), true);
}
}


