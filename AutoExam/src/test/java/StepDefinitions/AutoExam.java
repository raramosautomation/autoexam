package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;



public class AutoExam {

	WebDriver driver= null;
	String projectPath = System.getProperty("user.dir");

	String firstName, lastName, address, postal;
	String country, role, gender, filename;
	String skill1, skill2, skill3, skill4, skill5, skill6, goal;

	@Given("browser is open and launch the url provided")
	public void browser_is_open_and_launch_the_url_provided() {
		System.out.println("Inside step Given");
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath+ "/src/test/resources/Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		
		// Implicit wait timeout for 20seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		driver.manage().window().maximize();

	}		


	@When("user log-in his credentials, username and password")
	public void user_log_in_his_credentials_username_and_password() throws InterruptedException {
		driver.navigate().to("https://automationinterface1.front.staging.optimy.net/en/user/login/");

		driver.findElement(ByCssSelector.id("cookie-allow-all-button")).click();
		Thread.sleep(2000);	
 
		driver.findElement(ByCssSelector.id("login-email")).sendKeys("optimyautomationtester@gmail.com");
		driver.findElement(ByCssSelector.id("login-password")).sendKeys("yRMhojb7");

		driver.findElement(By.cssSelector("#login-form > div.position-relative > button")).click();
		Thread.sleep(2000);		  

	}


	@And("user click submit a new application")
	public void user_click_submit_a_new_application() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.cssSelector("#content > div > div > div > div > a")).click();
		Thread.sleep(2000);	

		//Locating element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.cssSelector("#content > div > div > div > div > section > div > a"));

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Element.click();
		Thread.sleep(3000);


	}

	@And("user fill-out the forms")
	public void user_fill_out_the_forms() throws InterruptedException {


		driver.findElement(ByCssSelector.id("629d7b5a-f6a1-5a14-ac1d-21b2fafdbdef")).sendKeys("Jose");
		driver.findElement(ByCssSelector.id("23e5e47e-bab1-5a1e-9929-f180182bda43")).sendKeys("Rizal");
		firstName = driver.findElement(ByCssSelector.id("629d7b5a-f6a1-5a14-ac1d-21b2fafdbdef")).getAttribute("value");
		lastName = driver.findElement(ByCssSelector.id("23e5e47e-bab1-5a1e-9929-f180182bda43")).getAttribute("value");
	
		driver.findElement(By.cssSelector("#\\37 172c3f2-f508-5f9c-82a1-11ce9d0f3edc\\:\\:c3f44a2e-72e9-587b-b88c-b5c9fbeed2db")).sendKeys("Manila, Philippines");
		address = driver.findElement(By.cssSelector("#\\37 172c3f2-f508-5f9c-82a1-11ce9d0f3edc\\:\\:c3f44a2e-72e9-587b-b88c-b5c9fbeed2db")).getAttribute("value");
		

		driver.findElement(By.cssSelector("#container_e57df0b5-c2ad-514a-967f-ee8b962f5ed4 > div > input")).sendKeys("1000");
		driver.findElement(By.linkText("1000 - Bruxelles / Brussel")).click();
		postal =  driver.findElement(By.cssSelector("#container_e57df0b5-c2ad-514a-967f-ee8b962f5ed4 > div > input")).getAttribute("value");
		

		driver.findElement(By.cssSelector("#\\37 e595970-fc12-558c-9eaf-385735fcae6b")).click();		
		try{
			// Waits for 20 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

			// Wait until expected condition size of the dropdown increases and becomes more than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver driver)  
				{
					Select select = new Select(driver.findElement(By.cssSelector("#\\37 e595970-fc12-558c-9eaf-385735fcae6b")));
					return select.getOptions().size()>1;
				}
			});

			//To select the first option
			Select select = new Select(driver.findElement(By.cssSelector("#\\37 e595970-fc12-558c-9eaf-385735fcae6b")));
			select.selectByVisibleText("Philippines");

		}catch(Throwable e){
			System.out.println("Error found: "+e.getMessage());
		}

		country = driver.findElement(By.cssSelector("#\\37 e595970-fc12-558c-9eaf-385735fcae6b > option:nth-child(175)")).getText(); 
		driver.findElement(ByCssSelector.name("Filedata")).sendKeys(projectPath+"/src/test/resources/File/cutedog.png");

		filename = driver.findElement(By.cssSelector("#list_d370f504-7ff5-509f-babb-d80126387290 > li > div > a")).getText(); 
		
		driver.findElement(By.cssSelector("#container_f3fa11a5-a516-5cec-9025-b940b1b113d0 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		gender = driver.findElement(By.cssSelector("#container_f3fa11a5-a516-5cec-9025-b940b1b113d0 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();


		driver.findElement(By.cssSelector("#field_f801d7d8-0762-5407-95f9-b8c3a793157c")).click();		

		driver.findElement(ByCssSelector.id("7026c894-4e85-5e16-910a-b19ca1013c74")).click();
		role = driver.findElement(By.cssSelector("#\\37 026c894-4e85-5e16-910a-b19ca1013c74")).getText();
	
		driver.findElement(By.cssSelector("#container_3fe36edc-80b0-5574-b7ad-7cfe074acfc1 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		driver.findElement(By.cssSelector("#container_5ab6a927-7b72-5869-acc3-0db0858bc495 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		driver.findElement(By.cssSelector("#container_f49b4d08-527e-5edc-9acd-5386bb2e188d > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		driver.findElement(By.cssSelector("#container_36c255b7-8d7c-50b9-8e75-b2ae9a57185b > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		driver.findElement(By.cssSelector("#container_9ae096b7-77d8-5dca-98fd-c19b4bf28688 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();
		driver.findElement(By.cssSelector("#container_8ea15213-d487-50b7-b6e1-73d26826b37e > label > div > div.custom-control-label.radio-checkbox-li-element-label")).click();

		skill1 = driver.findElement(By.cssSelector("#container_3fe36edc-80b0-5574-b7ad-7cfe074acfc1 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();
		skill2 = driver.findElement(By.cssSelector("#container_5ab6a927-7b72-5869-acc3-0db0858bc495 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();
		skill3 = driver.findElement(By.cssSelector("#container_f49b4d08-527e-5edc-9acd-5386bb2e188d > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();
		skill4 = driver.findElement(By.cssSelector("#container_36c255b7-8d7c-50b9-8e75-b2ae9a57185b > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();
		skill5 = driver.findElement(By.cssSelector("#container_9ae096b7-77d8-5dca-98fd-c19b4bf28688 > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();
		skill6 = driver.findElement(By.cssSelector("#container_8ea15213-d487-50b7-b6e1-73d26826b37e > label > div > div.custom-control-label.radio-checkbox-li-element-label")).getText();

		driver.switchTo().frame(driver.findElement(By.cssSelector("#cke_1_contents > iframe")));
		driver.findElement(By.cssSelector("body")).sendKeys("To be part of your prestigious company!");
		goal = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(goal);
		driver.switchTo().defaultContent();

	}

	@And("user click the next button")
	public void user_click_the_next_button() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Locating element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.cssSelector("#navButtonNext"));

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Element.click();
		Thread.sleep(3000);


	}

	@And("user verify if all the inputted values displayed in the summary screen")
	public void user_verify_if_all_the_inputted_values_displayed_in_the_summary_screen() {

	}

	@And("user click validate and send button")
	public void user_click_validate_and_send_button() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		assertEquals(firstName, driver.findElement(By.cssSelector("#container_629d7b5a-f6a1-5a14-ac1d-21b2fafdbdef > div")).getText());
		assertEquals(lastName, driver.findElement(By.cssSelector("#container_23e5e47e-bab1-5a1e-9929-f180182bda43 > div")).getText());
	
		
		assertEquals(address, driver.findElement(By.cssSelector("#container_c3f44a2e-72e9-587b-b88c-b5c9fbeed2db > p")).getText());
		assertEquals(postal, driver.findElement(By.cssSelector("#container_e57df0b5-c2ad-514a-967f-ee8b962f5ed4 > p")).getText());
		assertEquals(country, driver.findElement(By.cssSelector("#container_7e595970-fc12-558c-9eaf-385735fcae6b > p")).getText());
	
		
		WebElement Element1 = driver.findElement(By.cssSelector("#container_d370f504-7ff5-509f-babb-d80126387290 > div > ul > li > a"));

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		
		
		assertEquals(filename, driver.findElement(By.cssSelector("#container_d370f504-7ff5-509f-babb-d80126387290 > div > ul > li > a")).getText());
		assertEquals(gender, driver.findElement(By.cssSelector("#container_f3fa11a5-a516-5cec-9025-b940b1b113d0")).getText());
		assertEquals(role, driver.findElement(By.cssSelector("#container_f801d7d8-0762-5407-95f9-b8c3a793157c > div > p")).getText());
		

		WebElement Element2 = driver.findElement(By.cssSelector("#save-n-exit > a"));

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element2);
		
		assertEquals(skill1, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_3fe36edc-80b0-5574-b7ad-7cfe074acfc1")).getText());
		assertEquals(skill2, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_5ab6a927-7b72-5869-acc3-0db0858bc495")).getText());
		assertEquals(skill3, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_f49b4d08-527e-5edc-9acd-5386bb2e188d")).getText());
		assertEquals(skill4, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_36c255b7-8d7c-50b9-8e75-b2ae9a57185b")).getText());
		assertEquals(skill5, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_9ae096b7-77d8-5dca-98fd-c19b4bf28688")).getText());
		assertEquals(skill6, driver.findElement(By.cssSelector("#\\ \\ \\ \\ container_8ea15213-d487-50b7-b6e1-73d26826b37e")).getText());
		assertEquals(goal, driver.findElement(By.cssSelector("#container_91296806-02e6-5bb5-bac0-deb4cbf64a64 > div")).getText());
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//driver.findElement(By.xpath("//div[@class='d-none d-md-flex justify-content-between align-items-center']/button[@id='submitButton']")).click();
		driver.findElement(By.cssSelector("div.d-none.d-md-flex.justify-content-between.align-items-center > button#submitButton")).click();
		
		Thread.sleep(3000);
				
	}

	@Then("user is redirected to thank you page")
	public void user_is_redirected_to_thank_you_page() {

		driver.getPageSource().contains("Thank you for submitting your project");
		driver.close();
		driver.quit();
	}




}
