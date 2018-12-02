package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver , ExtentTest test, WebDriverWait wait){
        super(driver ,test,wait);
    }

    //*********WebElement*********
    By imgFnpLogo = By.id("fnplogo");

    //*********Page Methods*********
    public void verifyHomePageLoad(ExtentTest test){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       Boolean result = driver.findElement(imgFnpLogo).isDisplayed();
       if(result ==true) {
           test.log(LogStatus.PASS, "URL Launched Successfully");
       } else{
           test.log(LogStatus.FAIL, "URL Not Launched");
       }

    //   Assert.assertFalse(driver.findElement(imgFnpLogo).isDisplayed(),"URL Not successfully launched");

    }

}
