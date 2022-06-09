import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JabaTalks {

	static WebDriver driver;
	static WebDriverWait w;

	//Change the chromedriver path before running the code
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\selenium-2.53.1\\chromedriver.exe");  
		
		//Step: Launch a new Browser
		driver=new ChromeDriver();
		w = new WebDriverWait(driver, 30);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		
		//Step: Open URL https://jt-dev.azurewebsites.net/#/SignUp
		driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
		
		Thread.sleep(2000);
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Create Your Account']")));
		
		//Step: Validate that the dropdown has "English" and "Dutch"
		driver.findElement(By.id("language")).click();
		
		try
		{
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"ui-select-choices-row-inner\"]/div[text()='English']")));
		}
		catch(Exception e)
		{
			System.out.println("English Language not present");	
		}
		try
		{
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"ui-select-choices-row-inner\"]/div[text()='Dutch']")));
		}
		catch(Exception e)
		{
			System.out.println("Dutch Language not present");
			
		}
		
		driver.findElement(By.xpath("//a[@class=\"ui-select-choices-row-inner\"]/div[text()='English']")).click();
		
		//Step: Fill in your name.
		driver.findElement(By.id("name")).sendKeys("Suraj Rayanade");
		driver.findElement(By.id("orgName")).sendKeys("Suraj Rayanade");
		driver.findElement(By.id("singUpEmail")).sendKeys("suraj.rayanade@gmail.com");
		
		//Step: Click on "I agree to the Terms And Conditions"
		driver.findElement(By.xpath("//label[@class=\"ui-checkbox\"]/span[text()='I agree to the']")).click();
		
		Thread.sleep(2000);
		
		//Step: Click on "SignUp"
		driver.findElement(By.xpath("//button[@type='submit' and text()='Get Started']")).click();
		
		Thread.sleep(2000);
		
		//Step: Validate that you received an email.
		try
		{
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' A welcome email has been sent. Please check your email. ']")));
			System.out.println("Signup Successful, eMail sent..!");
		}
		catch(Exception e)
		{
			System.out.println("Signup not successful");
			
		}
		
		Thread.sleep(10000);
		
		driver.close();
	
	}
}
