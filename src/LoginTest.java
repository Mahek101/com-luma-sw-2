import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Before
    public void setUp(){
        openBrowser("https://magento.softwaretestingboard.com");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("megha123@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Megha123");
        driver.findElement(By.id("send2")).click();
        String expectedText = "Welcome";

       // Assert.assertEquals("User is not on login page",expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("megha12389@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Megha123");
        driver.findElement(By.id("send2")).click();
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals("Message is not displayed",expectedText,actualText);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        driver.findElement(By.linkText("Sign In")).click();// click on sign in link
        driver.findElement(By.id("email")).sendKeys("megha123@gmail.com"); // enter email address
        driver.findElement(By.id("pass")).sendKeys("Megha123");
        driver.findElement(By.id("send2")).click();// enter password
        driver.findElement(By.xpath("//span[@class='customer-name']")).click();//Find down aero and click on it
        driver.findElement(By.linkText("Sign Out")).click();//Find Sign out link and click on it.
        // Verify the 'You are signed out' text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement signOutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
        assert signOutMessage.getText().equals("You are signed out");
    }

}
