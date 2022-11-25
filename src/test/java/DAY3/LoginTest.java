package DAY3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {
    
    WebDriver driver;
    WebElement id;
    WebElement pass;
    WebElement btnLogin;
    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        id=driver.findElement(By.id("txtUsername"));
        pass=driver.findElement(By.id("txtPassword"));
        btnLogin=driver.findElement(By.id("btnLogin"));
        
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
    
    @Test
    public void validUsernameandPassword() throws InterruptedException
    {
        id.sendKeys("Admin");
        pass.sendKeys("ASDFwhuhpp3lhdz3k47iw%\r\n");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    
    @Test
    public void invalidUsernameandPassword() throws InterruptedException
    {
        id.sendKeys("abc");
        pass.sendKeys("abc");
        btnLogin.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='divLoginButton']//span")).getText().contains("Invalid credentials"));
    }
    
    public void validUsernameandinvalidPassword() {
    	id.sendKeys("Admin");
    	pass.sendKeys("12345fds");
    	btnLogin.click();
    	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='divLoginButton']//span")).getText().contains("Invalid credentials"));
    }



}
