package module_pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import creation.Baseclass;

public class TemplateCreation extends Baseclass
{
	@Test(priority = 1)
	public void self_issue_template() throws InterruptedException
	{
		test = extent.createTest("Click on template creation button");
		driver.findElement(By.xpath(prop.getProperty("templatecreationbtn"))).click();
		
		
		Thread.sleep(5000);
		
	}
	@Test(priority = 2)
	public void setting_tab_fields() throws InterruptedException
	{
		test = extent.createTest("Verify the tempalte name");
		driver.findElement(By.id("name")).clear();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys(prop.getProperty("value"));
		
		test = extent.createTest("Verify the tempalte status");
		Select vale = new Select(driver.findElement(By.id("status")));
		List<WebElement> value2 = vale.getOptions();
		System.out.println("element size is"+ value2.size());
		for (int i = 0; i < value2.size(); i++) 
		{
			System.out.println("value is ...."+value2.get(i).getText());
		}
		vale.selectByVisibleText("Approved");
		
		test = extent.createTest("Verfiy the tempatle card type");
		Select Card_Type = new Select(driver.findElement(By.id("reference_name")));
		List<WebElement> cardvalue = Card_Type.getOptions();
		System.out.println("element size is"+ cardvalue.size());
		for(int j= 0;j<cardvalue.size();j++)
		{
			System.out.println("value is..."+cardvalue.get(j).getText());
		}
		Card_Type.selectByVisibleText("Custom");
		driver.findElement(By.id("reference_name_custom")).sendKeys("automation testing template");
		
		// check the clear button.
		boolean clear_btn =driver.findElement(By.id("clear-tnc")).isEnabled();
		System.out.println("clear button status........"+clear_btn);
		
		driver.findElement(By.id("orgterms")).sendKeys("nasmbmds mabsdmasd amdsbmad ambdmabdm amsbdm"
				+ "asdmabsmdbmabsmdbmasdabsmdbmabsdmambdsm amdbmabdmbamdb"
				+ "asdkhakshdkhaskdasdkahskddsbskdhakhkdhkasd");
		
		Thread.sleep(2000);
		
		boolean clear_after_btn =driver.findElement(By.id("clear-tnc")).isEnabled();
		System.out.println("clear button status........"+clear_after_btn);
		
		 
	}
	
	@Test(priority = 3)
	public void card_design_tab() throws InterruptedException 
	{
		 test = extent.createTest("verify the card design functionality");
		 driver.findElement(By.id("obj-4")).click();
		 
		 driver.findElement(By.id("background_color")).click();
		 
		 Actions color = new Actions(driver);
		 color.moveByOffset(0, 200);
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("logo_text")).clear();
		 driver.findElement(By.id("logo_text")).sendKeys("dfasd sdfsdnmfms fsdfsdf");
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,3000)");
		 
		 driver.findElement(By.id("full_logoToUpload")).sendKeys("/home/bhushank/Downloads/images/bajaj-auto-logo.png");
		 	 
		
	}
	
	@Test(priority = 4)
	public void card_Fields_tab() throws InterruptedException
	{
		
		test = extent.createTest("All data field value is verified sucessfully");
		driver.findElement(By.id("obj-5")).click();
		
		// name field selection
		Select name = new Select(driver.findElement(By.id("p_source_1")));
		name.selectByVisibleText("IDMS: Static Value");
		driver.findElement(By.id("p_string_1")).sendKeys("name field value enter");
		
		Select fr_field = new Select(driver.findElement(By.id("sec_num_flds")));
		fr_field.selectByIndex(3);
		
		//Front field value selection
		String label = "", data_source = "", data_value = "";
		
		for (int i=1;i<=3;i++)
		{
			label = "s_label_";
			label = label+i;
			driver.findElement(By.id(label)).sendKeys("vaaas ld jajd"+i);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			data_source = "s_source_";
			data_source = data_source+i;
			Select data_Value_sr = new Select(driver.findElement(By.id(data_source)));
			data_Value_sr.selectByVisibleText("IDMS: Static Value");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			data_value = "s_string_";
			data_value = data_value+i;
			driver.findElement(By.id(data_value)).sendKeys("enter thesdfbm fmbsmf smfbm");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		}
		Thread.sleep(3000);
		// secondary field value selection
		
		driver.findElement(By.xpath("//a[@data-tab='1']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select sec_field = new Select(driver.findElement(By.id("aux_num_flds")));
		sec_field.selectByIndex(4);
		String aux_label = "", aux_data_source = "", aux_data_value = "";
		
		for (int i=1;i<=4;i++)
		{
			aux_label = "a_label_";
			aux_label = aux_label+i;
			driver.findElement(By.id(aux_label)).sendKeys("vaaas ld jajd");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			aux_data_source = "a_source_";
			aux_data_source = aux_data_source+i;
			Select data_Value_sr = new Select(driver.findElement(By.id(aux_data_source)));
			data_Value_sr.selectByVisibleText("IDMS: Static Value");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			aux_data_value = "a_string_";
			aux_data_value = aux_data_value+i;
			driver.findElement(By.id(aux_data_value)).sendKeys("enter thesdfbm fmbsmf smfbm");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		}
		Thread.sleep(2000);
		// back field
		driver.findElement(By.xpath("//a[@data-tab='2']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select back_field = new Select(driver.findElement(By.id("back_num_flds")));
		back_field.selectByIndex(4);
		
		String back_field_label="", back_field_datasource="", back_field_value="";
		
		for(int i=1;i<=4;i++)
		{
			back_field_label = "b_label_";
			back_field_label = back_field_label+i;
			driver.findElement(By.id(back_field_label)).sendKeys("back field value"+i);
			
			back_field_datasource = "b_source_";
			back_field_datasource =back_field_datasource+i;
			Select back_field_datasource_value = new Select(driver.findElement(By.id(back_field_datasource)));
			back_field_datasource_value.selectByVisibleText("IDMS: Static Value");
				
			back_field_value = "b_string_";
			back_field_value = back_field_value+i;
			driver.findElement(By.id(back_field_value)).sendKeys("back field value data"+i);
	
		}
	
		// media field
		driver.findElement(By.xpath("//a[@data-tab='3']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[contains(text(),'Enable media checkbox')]")).click();
		
	}
	@Test(priority = 5)
	public void card_barcode_tab() throws InterruptedException
	{
		driver.findElement(By.id("obj-6")).click();
		Select barcode_source = new Select(driver.findElement(By.id("barcode_id_value_source")));
		barcode_source.selectByVisibleText("IDMS: Static Value");
		driver.findElement(By.id("barcode_value")).sendKeys("smdfnmsdf");
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void card_Issucance_tab() throws InterruptedException
	{
		

		
	}
	
	
	/*@Test(priority = 6)
	public void card_Expiration_tab()
	{
		driver.findElement(By.id("obj-7")).click();
		
	}*/
	
	
	
	
	
	/*@Test(priority = 7)
	public void card_Issuance_tab()
	{
		driver.findElement(By.id("obj-8")).click();
		
	}*/

}
