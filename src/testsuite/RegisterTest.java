package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Before
    public void setUp(){
        openBrowser("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void verifyThatSignInPageDisplay(){
        driver.findElement(By.linkText("Create an Account")).click();// Find create an account link and click on it
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();// Find and get actual text
        Assert.assertEquals("Sign in page is not displayed", expectedText, actualText);// Checking Expected text and Actual text
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Create an Account")).click();// Find create an account link and click on it
        driver.findElement(By.id("firstname")).sendKeys("Megha");// Find Firstname field and enter value
        driver.findElement(By.id("lastname")).sendKeys("Mehta");// Find Lastname field and enter value
        driver.findElement(By.xpath("//div[@class='field choice newsletter']"));// Find checkbox and click
        driver.findElement(By.id("email_address")).sendKeys("megha123@gmail.com");// Find email field and enter email
        driver.findElement(By.id("password")).sendKeys("Megha123");// Find password field and enter password
        driver.findElement(By.id("password-confirmation")).sendKeys("Megha123");// Find confirm password field and enter password
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();// Find create an account button and click on it
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();//Find actual text and get it with get method
        Assert.assertEquals("User is not on main website store",expectedText,actualText);// Checking Actual text with Expected text
        driver.findElement(By.xpath("//span[@class='customer-name']")).click();//Find down aero and click on it
        driver.findElement(By.linkText("Sign Out")).click();//Find Sign out link and click on it.
        // Verify the 'You are signed out' text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement signOutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
        assert signOutMessage.getText().equals("You are signed out");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
