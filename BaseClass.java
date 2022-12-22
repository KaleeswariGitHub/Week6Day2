package week6.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class BaseClass 
{
	
	public  ChromeDriver driver;
	public static Shadow shadowDriver;
	public static String number;
	public WebElement shadowFrame;
	public String filename;
	
	
	@Parameters({"url","username","password"})
	@BeforeMethod(alwaysRun = true)
	
	public void precondition(@Optional("https://dev120518.service-now.com") String url,@Optional("admin") String username,@Optional("Christy@09") String password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
		shadowDriver= new Shadow(driver);
		Actions moveMouse= new Actions(driver); 
		Thread.sleep(10000);
		WebElement shadowAll = shadowDriver.findElementByXPath("//div[text()='All']");
		shadowAll.click();
		Thread.sleep(7000);
		WebElement shadowIncident = shadowDriver.findElementByXPath("//span/span[text()='Incidents']");
		shadowIncident.click();
		Thread.sleep(10000);
		shadowFrame= shadowDriver.findElementByXPath("//iframe");
		driver.switchTo().frame(shadowFrame);
	}
	
	@AfterMethod
	public void postcondition()
	{
		//driver.close();
	}

	@DataProvider(name = "fetchdata")
	public String[][] getData() throws IOException
	{
		return ReadExcel.readData(filename);
	}
}
