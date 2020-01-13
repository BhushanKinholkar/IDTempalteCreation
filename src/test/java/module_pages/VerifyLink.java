package module_pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import creation.Baseclass;

public class VerifyLink extends Baseclass
{
	@Test(priority = 1)
	public void verfiy_page_details()
	{
		test = extent.createTest("verify the page logo & user login email id & institution name");
		boolean logo = driver.findElement(By.id("homeLogo-title")).isDisplayed();
		System.out.println(logo);
	
		String user_name = driver.findElement(By.xpath("//div[@id='account-logo-card_userDetails']//a[@class='underline']")).getText();
		System.out.println("Login user id is............."+ user_name);
		
		String login_ins_name = driver.findElement(By.xpath(prop.getProperty("logininsname"))).getText();
		System.out.println("Login institution name is......."+login_ins_name);
		
	}
	
	// Card data page verfiy 
	@Test(priority = 2)
	public void verify_pages_idphoto_page()
	{
		test = extent.createTest("verify the id photos page link");
		driver.findElement(By.linkText("ID Photos")).click();
		String idtitle = driver.getTitle();
		System.out.println("page title is.............." +idtitle);
	}
	
	@Test(priority = 3)
	public void verify_pages_cardtempaltebuilder_page()
	{
		test = extent.createTest("verify the card tempalte builder page link");
		driver.findElement(By.linkText("Card Template Builder")).click();
		String card_t_title = driver.getTitle();
		System.out.println("page title is.............." +card_t_title);
	}
	
	@Test(priority = 4)
	public void verify_cardRenew()
	{
		test = extent.createTest("verify the card renew page link");
		driver.findElement(By.linkText("Card Renewals")).click();
		String card_renew_title = driver.getTitle();
		System.out.println("page title is.............." +card_renew_title);
	}
	
	@Test(priority = 5)
	public void verify_data_sync() throws InterruptedException
	{
		Actions datasync = new Actions(driver);
		datasync.moveToElement(driver.findElement(By.xpath("//div[@id='sidemenu-list']//li[@data-menu='integrations-submenu']"))).build().perform();
		
		WebElement datasynclist= driver.findElement(By.xpath("//ul[@id='integrations-submenu']"));
		List<WebElement> sync_list = datasynclist.findElements(By.className("nav-item"));
		//Iterator<WebElement> sync_i = sync_list.iterator();
		System.out.println(sync_list.size());
		
		for(int i =0 ; i<=2;i++)
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			By addItem = (By) driver.findElement(By.xpath("//ul[@id='integrations-submenu']/child::li"));

			// get the "Add Item" element
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(addItem));

			//trigger the reaload of the page
			//driver.findElement(By.id("...")).click();

			// wait the element "Add Item" to become stale
			wait.until(ExpectedConditions.stalenessOf(element));

			// click on "Add Item" once the page is reloaded
			wait.until(ExpectedConditions.presenceOfElementLocated(addItem)).click();
			

		}
		
		
		/*
		while(sync_i.hasNext())
		{
			WebElement e = sync_i.next();
			System.out.println("message "+e.getText());
			e.click();
			Thread.sleep(3000);
			
		}
		*/
		
	
		/*test = extent.createTest("verify the data sync page link");
		driver.findElement(By.linkText("Data Sync")).click();
		String data_sync_title = driver.getTitle();
		System.out.println("page title is.............." +data_sync_title);*/
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	// Tools pages verify 
	@Test(priority = 6)
	public void Tools_Pages() throws InterruptedException
	{
		Actions tools = new Actions(driver);
		tools.moveToElement(driver.findElement(By.xpath("//i[@class='fas fa-wrench fa-18px']"))).build().perform();
	
		test = extent.createTest("verify the Smart Link Redirect Builder page link");
		driver.findElement(By.linkText(prop.getProperty("SLRBuilder"))).click();
		String Smart_Link_Redirect_Builder = driver.getTitle();
		System.out.println("page title is........."+Smart_Link_Redirect_Builder);	
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	@Test(priority = 7)
	public void SLRT_Link()
	{
		test = extent.createTest("verify the Smart Link Redirect Templates page link");
		driver.findElement(By.linkText(prop.getProperty("SLRTemplates"))).click();
		String SLRBuilder_title = driver.getTitle();
		System.out.println("page title is........."+SLRBuilder_title);
		
	}
	
	@Test(priority = 8)
	public void JWTV_Link()
	{
		test = extent.createTest("verify the JWT Validator page link");
		driver.findElement(By.linkText(prop.getProperty("JWTValidator"))).click();
		String JWTV_title= driver.getTitle();
		System.out.println("page title is........."+JWTV_title);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@Test(priority = 9)
	public void JWTG_Link() throws InterruptedException
	{
		test = extent.createTest("verify the JWT Generator page link");
		driver.findElement(By.linkText(prop.getProperty("JWTGenerator"))).click();
		String JWTV_title = driver.getTitle();
		System.out.println("page title is........."+JWTV_title);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	//Notification page
	@Test(priority = 10)
	public void notification_method() throws InterruptedException
	{
		Actions notification = new Actions(driver);
		notification.moveToElement(driver.findElement(By.xpath("//div[@id='sidemenu-list']//li[@data-menu='notifications-submenu']"))).build().perform();
		
		WebElement countryUL= driver.findElement(By.xpath("//ul[@id='notifications-submenu']"));
		List<WebElement> countriesList=countryUL.findElements(By.tagName("li"));
		for(int i = 1;i<countriesList.size();i++)
		{
			countriesList.get(i).click();
			String title= driver.getTitle();
			System.out.println(title);
		}
		
		
		/*for (WebElement li : countriesList)
		{
			
				li.click();
				//String titleis =driver.getTitle();
				//System.out.println(titleis);
		
		}*/
	
		
		Thread.sleep(2000);
	}
	
	/*
	//Account page
	@Test(priority = 11)
	public void account_information() throws InterruptedException
	{
		Actions account = new Actions(driver);
		account.moveToElement(driver.findElement(By.xpath("//i[@class='fas fa-building fa-18px']"))).build().perform();
		 Thread.sleep(2000);
		 
		test = extent.createTest("verify the account information page link");
		driver.findElement(By.linkText(prop.getProperty("accountinformation"))).click();
		String account_info = driver.getTitle();
		System.out.println("page title is......."+account_info);
	}
	
	@Test(priority = 12)
	public void account_admin()
	{
		test = extent.createTest("verify the Account Admins page link");
		driver.findElement(By.linkText(prop.getProperty("accoutadmins"))).click();
		String accountadmins = driver.getTitle();
		System.out.println("page title is......."+accountadmins);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority = 13)
	public void email_prefrences()
	{
		test = extent.createTest("verify the Email Prefrences page link");
		driver.findElement(By.linkText(prop.getProperty("emailpref"))).click();
		String  emailpref= driver.getTitle();
		System.out.println("page title is......."+emailpref);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 14)
	public void csv_import()
	{
		test = extent.createTest("verify the CSV import page link");
		driver.findElement(By.linkText(prop.getProperty("csvimport"))).click();
		String  csvimport= driver.getTitle();
		System.out.println("page title is......."+csvimport);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/
	

}
