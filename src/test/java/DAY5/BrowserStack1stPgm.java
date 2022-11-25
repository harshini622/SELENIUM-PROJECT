package DAY5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserStack1stPgm {
	WebDriver driver;
	
	@Parameters({"browserName","browserVersion","os","osVersion"})
	@BeforeMethod
	public void setup(String s11,String s22, String s33, String s44) {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("browserName", s11);
		
		capabilities.setCapability("browserVersion", s22);
		
		capabilities.setCapability("os", s33);
		
		capabilities.setCapability("osVersion", s44);

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
}
}

