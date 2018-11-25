package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class HomepageTest extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.
    @Test(priority = 0, description ="Test to verify successful URL Launch by verifying logo" )
    public void successfulHomePageLoad() {
        try {
            //ExtentReports Description
            ExtentTestManager.getTest().setDescription("Test to verify successful URL Launch by verifying logo");

            //*************PAGE INSTANTIATIONS*************
            HomePage homepage = new HomePage(driver);

            //*************PAGE METHODS*************
            //Invoke URL
            homepage.getURL();
            //Verify Homepage Loads successfully
            homepage.verifyHomePageLoad();
        }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}


