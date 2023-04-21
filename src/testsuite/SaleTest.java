package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SaleTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.id("ui-id-8")).click();// Find Sale menu tab and click on it.
        driver.findElement(By.linkText("Jackets")).click();// Find jackets link and click on it.
        String expectedText = "Jackets";// Expected text on page
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();//Get actual text on page
        Assert.assertEquals("Text is not displayed", expectedText, actualText);// Checking actual vs expexcted test
        // Count the Total Item Displayed on Page and print the name of all items into console.
        List<WebElement> items = new ArrayList<>();
        items = driver.findElements(By.cssSelector(".products-grid .product-item"));
        int actualItemCount = items.size();
        System.out.println("Total items displayed on page: " + actualItemCount);
        System.out.println("Names of all items on page:");
        for (WebElement item : items) {
            System.out.println(item.findElement(By.cssSelector(".product-item-link")).getText());
        }
        // Verify total 12 Items displayed on page.
        int expectedItemCount = 12;
        Assert.assertEquals("Number of items displayed on page is not as expected.", expectedItemCount, actualItemCount);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}


