package Steps;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportingSteps {
	
	WebDriver driver;
	 Boolean res;
	 JavascriptExecutor js;

	
   @Before
   public void setup() 
   {
   	System.setProperty("webdriver.chrome.driver", "C:\\Automation Training\\Cucumber_Raghav\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().window().maximize();	
   	
   }
   
   @After
   public void teardown() 
   {
   	driver.close();
   	driver.quit();
   }
   
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		driver.get("https://example.testproject.io/web/");
	}

	@When("User provides userid and Password")
	public void user_provides_userid_and_password() throws Throwable {
		driver.findElement(By.id("name")).sendKeys("Raghav");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("12345");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws Throwable {
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
	}

	@Then("user lands to home page")
	public void user_lands_to_home_page() throws Throwable {
	    
		System.out.println("User naviagted to homepage");
		js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
	}

	@When("Logout button is displayed")
	public void logout_button_is_displayed() {
	   
		 res= driver.findElement(By.xpath("//button[@id='logout']")).isDisplayed();
		   System.out.println(res);
	}

	@Then("login is success")
	public void login_is_success() {
	  if(res==true)
	  {
		  System.out.println("Login success");
	  }
		  
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		
		driver.findElement(By.xpath("//button[@id='logout']")).click();
	   
	}
	

	@Then("user will navigate back to loginpage")
	public void user_will_navigate_back_to_loginpage() {
	  System.out.println("Logout successfully");
	}


}
