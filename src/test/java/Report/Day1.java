package Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

    WebDriver driver;
   @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
        
        
    @AfterClass
    public void teardown() {
        driver.quit();
    }

   @Parameters("browsers")
    @Test


  public void login() {


       driver.findElement(By.name("q")).sendKeys("Automation Testing");
        
        String title=driver.getTitle();
        System.out.println("Title is "+title);
        String url=driver.getCurrentUrl();
        System.out.println("Url is "+url);
     
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        }
        
        
        }