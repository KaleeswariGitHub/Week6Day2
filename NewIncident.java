package week6.day1;
/*
 * 1.Create new incident
1. Launch ServiceNow application
2. Login with valid credentials (refer the document to create the instance)
3. Enter Incident in filter navigator and press enter"
4. Click on Create new option and fill the manadatory fields
5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
******************************************
 */

import java.awt.Desktop.Action;
import java.awt.Frame;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class NewIncident extends BaseClass  {

	@BeforeClass
	public void setData()
	{
		filename="ServiceNow";
	}
	
	@Test (dataProvider = "fetchdata")
	public  void testNewIncident(String url,String username,String password) throws InterruptedException
	{
					
		WebElement incidentNew = shadowDriver.findElementByXPath("//button[text()='New']");
		incidentNew.click();
		Thread.sleep(5000);
		WebElement incidentNumber = driver.findElement(By.id("incident.number"));
		number = incidentNumber.getAttribute("value");
		System.out.println("Incident Number: "+ number);
		WebElement shortDesc = driver.findElement(By.id("incident.short_description"));
		shortDesc.sendKeys("Incident_" + number);
		WebElement buttonSubmit= shadowDriver.findElementByXPath("//button[text()='Submit']");
		buttonSubmit.click();
		Thread.sleep(5000);
		shadowDriver.findElementByXPath("//td[@name='number']//input").sendKeys(number,Keys.ENTER);
		Thread.sleep(3000);
        WebElement verifyNumber= shadowDriver.findElementByXPath("//a[text()='"+number+"']");
        String num = verifyNumber.getText();
        System.out.println("Verified Number: "+num);
        
        if(number.equals(num))
               	System.out.println("Incident number is verifed");
               	
         else 
		        System.out.println("Incident number is wrong");
        Thread.sleep(3000);
		
	}

}
