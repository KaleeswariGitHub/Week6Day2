package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident extends BaseClass {

	@Test
	public void testDeleteIncident () throws InterruptedException 
	{
		
			
        shadowDriver.findElementByXPath("//td[@name='number']//input").sendKeys(number,Keys.ENTER);
        Thread.sleep(3000);
        shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
        
        
        shadowDriver.findElementByXPath("//button[@id='sysverb_delete']").click();
       // driver.switchTo().frame(shadowFrame);
        
        WebElement okClick = driver.findElement(By.xpath("//button[@id='ok_button']"));
        //driver.executeScript("arguments[0].click();", okClick);
        okClick.click();
        
//        WebElement okDelClick = shadowDriver.findElementByXPath("//button[@id='ok_button']");
//        driver.executeScript("arguments[0].click();", okDelClick);
//               
        driver.switchTo().frame(shadowFrame);
        shadowDriver.findElementByXPath("//td[@name='number']//input").sendKeys(number,Keys.ENTER);
        Thread.sleep(3000);
       // shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
        System.out.println("No records - displayed");
        

	}

}
