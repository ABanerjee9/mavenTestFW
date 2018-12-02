package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    public ExtentTest test;

    //Constructor WebDriver object argument to initialize a WebDriverWait object
    public BasePage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.test= test;
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT),this);
    }

    //Navigate to URL
    public void getURL(ExtentTest test) {
        String url = "https://www.fnp.com";
        try {
            driver.manage().deleteAllCookies();
            driver.get(url);
            test.log(LogStatus.PASS, "FNP URL Launched"+url);

        } catch (Exception e) {
            e.printStackTrace();
            test.log(LogStatus.FAIL," Loading URL - Fail");
        }
    }

    //Click Method
        public void click(By locator){
        driver.findElement(locator).click();
        }

     //Enter Text
    public void enterText(By locator){
        driver.findElement(locator).sendKeys();
    }

    //Read Test
    public String readText(By locator){
        String readString=null;
        readString = driver.findElement(locator).getText();
        return readString;
    }

    /**********Explicit wait methods for different conditions*******/

    //Wait for the visibility of the element
    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Wait for Element to disappear
    public void waitForElementToDisAppear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //Wait for a specific amount of time
    public void waitForTime(int waitTime) {
        long startTime = System.currentTimeMillis();
        long millis = waitTime * 60 * 1000;
        long endTime = startTime + millis;

        while (System.currentTimeMillis() < endTime) {
            System.out.println("Waiting for element");
        }
    }
}