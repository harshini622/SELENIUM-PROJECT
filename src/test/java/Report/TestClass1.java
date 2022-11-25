package Report;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestClass1 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
    }
    @AfterMethod
    public void clearup() {
        driver.quit();
        
    }
    @Test
    public void validCredentials()
    {
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Admin']")).isDisplayed(), true);
        //Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"), true);
    }
    @Test
    public void validUsernameInvalidPassword()
    {
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k7iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }
    @Test
    public void InvalidUsernamevalidPassword()
    {
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("A");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }
    @Test
    public void InvalidUsernameInvalidPassword()
    {
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("A");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }
    @Test
    public void noDetails() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }
    
    
    
    
    



}