package week6.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*
 * Launch ServiceNow application
2. Login with valid credentials 
3.  Enter Incident in filter navigator and press enter
4. click on open and Search for the existing incident and click on  the incident
5. Assign the incident to  Software group
6. Update the incident with Work Notes
7. Verify the Assignment group and Assigned for the incident
 */
public class AssignIncident  extends BaseClass{

	@Test
	public  void testAssignIncident() throws InterruptedException
	
	{
		Thread.sleep(5000);		
		WebElement statusElement = shadowDriver.findElementByXPath("//div[@class='input-group']//select");
		Select statusSelect= new Select(statusElement);
		statusSelect.selectByVisibleText("Opened");
			System.out.println("Selected");
		shadowDriver.findElementByXPath("//td[@name='number']//input").sendKeys(number,Keys.ENTER);
        Thread.sleep(3000);
        shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
        
        Set<String> windowSet= driver.getWindowHandles();
        List<String> windowList= new ArrayList<String>(windowSet);
        System.out.println(windowList.size());
        System.out.println(windowList);
        driver.switchTo().window(windowList.get(1));
        System.out.println("Child Title: "+driver.getTitle());
        
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("software",Keys.ENTER);
        driver.findElement(By.xpath("//td/a[text()='Software']")).click();
        Thread.sleep(5000);
        
        driver.switchTo().window(windowList.get(0));
        //driver.switchTo().frame(shadowFrame);
       // driver.switchTo().defaultContent();
        Thread.sleep(3000);
        
        Actions mouseMove= new Actions(driver);
        
        WebElement workText = shadowDriver.findElementByXPath("//textarea[@id='activity-stream-textarea']");
        mouseMove.scrollToElement(workText).perform();
        workText.sendKeys("SoftwareGroup");
        shadowDriver.findElementByXPath("//button[text()='Update']").click();
        System.out.println("Assigned to software");
        
        WebElement verifyIncident = shadowDriver.findElementByXPath("//table[@id='incident_table']/tbody/tr/td[@class='vt']/a[text()='"+number+"']");
        String verifyText = verifyIncident.getText();
        System.out.println(verifyText);
        
        if(verifyText.equals(number))
        {
        	WebElement getGroupText = shadowDriver.findElementByXPath("//a[text()='"+number+"']/following::a[text()='Software']");
        	String groupText = getGroupText.getText();
        	System.out.println(groupText);
        	if(groupText.equals("Software"))
        	    System.out.println("This incident belongs to Software Group");
        	else 
			    System.out.println("This incident belongs to "+groupText+" group");	
			
        }
	
		
		

	}

}
