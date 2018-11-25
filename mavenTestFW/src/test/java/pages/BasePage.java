package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static final int TIMEOUT = 5;
    public static final int POLLING = 10;

    protected WebDriver driver;
    private WebDriverWait wait;

    //Constructor WebDriver object argument to initialize a WebDriverWait object
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT),this);
    }

    //Navigate to URL
    public void getURL() {
        try {
            driver.get("https://www.fnp.com/");

        } catch (Exception e) {
            e.printStackTrace();
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