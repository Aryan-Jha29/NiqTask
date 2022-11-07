package Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task1 {
	
	@Test
	public void task() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jhar2001\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver); 
		
		Action sendEsc = action.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
		
		Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement login = driver.findElement(By.className("_1_3w1N"));

		login.click();
		
		Thread.sleep(3000);

		WebElement Username = driver.findElement(By.xpath("//span[contains(text(),'Enter Email/Mobile number')]/../../input"));
		Username.sendKeys("7001797668");
	
		Thread.sleep(2000);
		
		WebElement Password = driver.findElement(By.xpath("//span[contains(text(),'Enter Password')]/../../input"));
		Password.sendKeys("aryan@123456");
		
		Thread.sleep(2000);
		
		WebElement Continue = driver.findElement(By.xpath("//span[contains(text(),'Login')]/../..//button"));
		Continue.click();
		
		Thread.sleep(2000);
		
		//Assertion
		String expectedlTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedlTitle,"Title is mismatched");
		
		
		WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
		input.sendKeys("iphone 14 128gb");
		
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		search.click();
		
		Thread.sleep(2000);
		
		//Assertion
		String newTitle = "Iphone 14 128gb- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		String fetchnewTitle = driver.getTitle();
		Assert.assertEquals(newTitle, fetchnewTitle,"Title is mismatched");

		
		driver.findElement(By.xpath("//div[@class='_4rR01T']/../../..")).click();
		
		WebElement desc = driver.findElement(By.xpath("//li[contains(text(), '128 GB ROM')]"));
		
		//Assertion
		String prodSize = "128 GB ROM";
		String fetchProdSize = desc.getText();
		Assert.assertEquals(prodSize, fetchProdSize,"Title is mismatched");
		
		String parent_window=driver.getWindowHandle();

		System.out.println("Current window is - " + parent_window);
		
		Set<String>s = driver.getWindowHandles(); // Fetching and storing all the windows

		for (String window : s) 
		{ 
			driver.switchTo().window(window);
		} 
		
		WebElement AddToCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		AddToCart.click();
		
		System.out.println("Title of project is - " + driver.getTitle());
	}
}
