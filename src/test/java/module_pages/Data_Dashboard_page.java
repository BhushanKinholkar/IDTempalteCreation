package module_pages;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import creation.Baseclass;

public class Data_Dashboard_page extends Baseclass
{
	@Test(priority = 1)
	public void view_Card_link()
	{
		driver.findElement(By.linkText("View Data")).click();
	}
	@Test(priority = 2)
	public void Dashboard_filter() throws InterruptedException
	{

		Select filter_value = new Select(driver.findElement(By.id("filterStatus")));
		List<WebElement> filter_val = filter_value.getOptions();
		System.out.println(filter_val.size());
		
		/*Iterator<WebElement> val = filter_val.iterator();
		while (val.hasNext()) 
		{
			val.;
			driver.findElement(By.id("filterBtn")).click();
			
		}*/
	
		for(int i = 1;i < filter_val.size();i++)
		{	
			
	        String value = filter_val.get(i).getText();
	        System.out.println(i);
	        System.out.println(value);
	        
	        filter_value.selectByVisibleText(value);
	    
			
	        
	     //driver.findElement(By.id("filterBtn")).click();
	        //driver.navigate().refresh();
	   
		}
		
		
	}

}
