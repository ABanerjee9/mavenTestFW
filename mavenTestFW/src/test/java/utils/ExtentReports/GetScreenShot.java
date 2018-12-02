package utils.ExtentReports;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Aparajita on 12/2/2018.
 */
public class GetScreenShot extends ExtentTestManager {

    public static String capture(WebDriver driver, String screenShotName) throws IOException {
        /*
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest; */
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader = null;
        try {
            fileInputStreamReader = new FileInputStream(scrFile);
            byte[] bytes = new byte[(int) scrFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;

    }
}
