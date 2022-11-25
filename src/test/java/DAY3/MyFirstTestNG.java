package DAY3;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class MyFirstTestNG {
	
	@Test//(dependsOnMethods = "logoutFormApplication")
	public void login() {
		System.out.println("Login Done");
		Reporter.log("Login Done",true);
	}
	
	@Test(dependsOnMethods = "login")
	public void logoutFormApplication() {
		System.out.println("Logout Done");
		
	}
	}

