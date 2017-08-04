/**
 * 
 */
package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import junit.framework.Assert;

/**
 * @author oded
 *
 */
@RunWith(JUnit4.class)
public class PetClinicTest {
	String url = "http://localhost:8888/petclinic_sdk-1.0.0-SNAPSHOT";
	private WebDriver driver = null;
	
	@Before
	public void setup()
	{
		driver = new HtmlUnitDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);

	}
	@Test
	public void testPetclinic()
	{
		WebElement element = driver.findElement(By.tagName("h2"));
		String text = element.getText();
		Assert.assertEquals("Welcome", text);		
	}
	
	
	@Test
	  public void testAddOwner() throws Exception {
	    driver.findElement(By.linkText("Find owner")).click();
	    driver.findElement(By.linkText("Add Owner")).click();
	    driver.findElement(By.id("firstName")).clear();
	    driver.findElement(By.id("firstName")).sendKeys("Bob");
	    driver.findElement(By.id("lastName")).clear();
	    driver.findElement(By.id("lastName")).sendKeys("Smith");
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("Pine Ave");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("Los Angeles");
	    driver.findElement(By.id("telephone")).clear();
	    driver.findElement(By.id("telephone")).sendKeys("9999999");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		String fName = driver.findElement(By.xpath("//tr/td/b")).getText();
		System.out.println("fName= "+ fName);
		Assert.assertEquals("Bob Smith", fName);

	  }

	
	@After
	public void tearDown()
	{
		driver.close();
	}
}
