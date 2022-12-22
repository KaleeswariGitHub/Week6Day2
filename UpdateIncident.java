package week6.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
 * 1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Incident in filter navigator and press enter "
4. Search for the existing incident and click on the incident
5. Update the incidents with Urgency as High and State as In Progress
6. Verify the priority and state 
 */
public class UpdateIncident extends BaseClass {

	@Test
	public  void testUpdateIncident() throws InterruptedException {
		
						
         shadowDriver.findElementByXPath("//td[@name='number']//input").sendKeys(number,Keys.ENTER);
         Thread.sleep(3000);
         shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
         
         WebElement selectUrgency = shadowDriver.findElementByXPath("//select[@id='incident.urgency']");
		 Select urgency = new Select(selectUrgency);
		 urgency.selectByVisibleText("1 - High");
		 
		 WebElement selectState = shadowDriver.findElementByXPath("//select[@id='incident.state']");
		 Select state = new Select(selectState);
		 state.selectByVisibleText("In Progress");
		 
		 shadowDriver.findElementByXPath("//button[@id='sysverb_update']").click();
		 
		 shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
		 WebElement selectUrgency1 = shadowDriver.findElementByXPath("//select[@id='incident.urgency']");
		 String urgencyText = selectUrgency1.getAttribute("value");
		 WebElement selectState1 = shadowDriver.findElementByXPath("//select[@id='incident.state']");
		 String stateText = selectState1.getAttribute("value");
		 System.out.println("Urgency and State are updated.");
		 System.out.println("Urgency: "+urgencyText);
		 System.out.println("Sate: "+stateText);
		 if(urgencyText.equals("1") && stateText.equals("2"))
				 System.out.println("They are updated and verified");
		 else
               System.out.println("They are wrong");	
		 
		// driver.close();


	}

}
