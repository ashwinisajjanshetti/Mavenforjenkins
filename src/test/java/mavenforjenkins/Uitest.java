package mavenforjenkins;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Uitest {
	@Parameters("Browser")
	@Test
	public void startbrowser(String browserName) throws InterruptedException, AWTException {
		System.out.println("parameter value is:"+browserName);
		WebDriver driver=null;
		if(browserName.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);                    
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		System.out.println("Popup closed");
		
		driver.close(); 

	}

}
