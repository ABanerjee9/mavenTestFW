package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver){
        super(driver);
    }

    //*********WebElement*********
    By imgFnpLogo = By.id("fnplogo");

    //*********Page Methods*********
    public void verifyHomePageLoad(){
       /*Boolean result = driver.findElement(imgFnpLogo).isDisplayed();
       if(result ==true){
           System.out.println("Logo Displayed");*/
           Assert.assertTrue(driver.findElement(imgFnpLogo).isDisplayed(),"URL successfully launched");
      // }
    }

}
