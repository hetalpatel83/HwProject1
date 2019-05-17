package Proj1160519;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod
    //run before every method
    public void openBrowser(){
        System.out.println("here1");
        browserSelector.setUpBrowser();
        //Asking Driver to get the URL.
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    //run after every method //ITestResult result

    public void closeBrowser(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(ts, new File("Screenshots\\" + result.getName() + LongTimeStamp() + ".png"));

                System.out.println("Screenshot taken");

            } catch (Exception e) {

            }
            driver.quit();
        }
    }
}
