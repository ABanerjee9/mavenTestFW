package tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;
import utils.ExtentReports.GetScreenShot;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomepageTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod(Method method){
     //   ExtentTestManager.getTest().setDescription("Test to verify successful URL Launch by verifying logo");
        test = extent.startTest(this.getClass().getSimpleName()+" : " + method.getName(), method.getName());

    }
    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.
    @Test(priority = 0 )
    public void successfulHomePageLoad(){
        //ExtentReports Description
    // String s = ExtentTestManager.getTest().toString();



        //*************PAGE INSTANTIATIONS*************
        HomePage homepage = new HomePage(driver , test, wait);


        //*************PAGE METHODS*************
        //Invoke URL
        homepage.getURL(test);
        //Verify Homepage Loads successfully
        homepage.verifyHomePageLoad(test);
        }

    @AfterMethod
    public void afterMethod (Method method,ITestResult result) throws IOException {
        test.log(LogStatus.INFO , method.getName() + " ended");
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addBase64ScreenShot(screenShotPath));
        }
        extent.endTest(test);
    }
    }

