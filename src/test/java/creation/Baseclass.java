package creation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass 
{

	public ExtentReports extent;
	public ExtentTest loger;
	public ExtentHtmlReporter report;
	public ExtentTest test;
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream file;

	@BeforeTest
	public void beforeSuite() 
	{
		report = new ExtentHtmlReporter("/home/bhushank/eclipse-workspace/IDTemplateCreation/target/id123.html");
		extent = new ExtentReports();
		extent.attachReporter(report);

	}

	@BeforeClass
	public synchronized void beforeClass() throws Exception 
	{
		prop = new Properties();
		file = new FileInputStream(
				"/home/bhushank/eclipse-workspace/IDTemplateCreation/src/test/java/propertyfile/data.properties");
		prop.load(file);
		String browser_name = prop.getProperty("browser");
		System.out.println("Browser name is...." + browser_name);

		if (browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/bhushank/Downloads/chrome/chromedriver");
			driver = new ChromeDriver();

		} else if (browser_name.equals("firefox")) {

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority =0)
	public void login_system() {
		test = extent.createTest("Login the application");
		driver.findElement(By.xpath(prop.getProperty("emailid"))).sendKeys("google03@yopmail.com");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("321skycore");
		driver.findElement(By.xpath(prop.getProperty("loginbtn"))).click();
		driver.findElement(By.partialLinkText("aakdn")).click();

	}

	@AfterMethod
	public void teardown (ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, "TEST CASE FAILED IS..... " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "Test Case PASSED IS..... " + result.getName());

		} else if (result.getStatus() == ITestResult.SKIP) 
		{
			test.log(Status.SKIP, "Test Case SKIPPED IS..... " + result.getName());
		}
		extent.flush();
		
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.close();
		
	}

	
}
