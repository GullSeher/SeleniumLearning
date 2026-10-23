import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class wait {
	public static void main(String[]arg) {
		
			
			 WebDriver driver = new ChromeDriver();

		        try {
		            // Step 1: Create an explicit wait
		            WebDriverWait wait =
		                    new WebDriverWait(
		                            driver,
		                            Duration.ofSeconds(10)
		                    );

		            // Step 2: Open the login page
		            driver.get("https://practicetestautomation.com/practice-test-login/");

		            // Step 3: Wait for username field
		            WebElement username = wait.until(
		                    ExpectedConditions.visibilityOfElementLocated(
		                            By.name("username")
		                    )
		            );

		            // Step 4: Enter username
		            username.sendKeys("student");

		            // Step 5: Wait for password field
		            WebElement password = wait.until(
		                    ExpectedConditions.visibilityOfElementLocated(
		                            By.name("password")
		                    )
		            );

		            // Step 6: Enter test password
		            password.sendKeys("Password123");

		            // Step 7: Wait for Login button and click it
		            WebElement loginButton = wait.until(
		                    ExpectedConditions.elementToBeClickable(
		                            By.cssSelector("button[id='submit']")
		                    )
		            );

		            loginButton.click();

		            // Step 8: Wait for a dashboard heading
		            WebElement dashboard = wait.until(
		                    ExpectedConditions.visibilityOfElementLocated(
		                            By.tagName("h1")
		                    )
		            );

		            // Step 9: Print the resulting heading
		            System.out.println(
		                    "Page heading: " + dashboard.getText()
		            );
		            
		            
		            String actTitle = driver.getTitle();

		            if (actTitle.equals("Dashboard")) {
		                System.out.println("Test Passed");
		            } else {
		                System.out.println("Test Failed actual title is :" + actTitle);
		            }
		            
		            String actualTitle = driver.getTitle();
		            

		            Assert.assertEquals(actualTitle, "Logged In Successfully | Practice Test Automation");

		        } finally {
		            // Step 10: Close the browser session
		            driver.quit();
		        }
			
			
			
		
	}
	

}
