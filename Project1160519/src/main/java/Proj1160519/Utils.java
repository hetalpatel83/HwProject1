package Proj1160519;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {
    //extends BasePage
    static String actualResult;
    private static String expectedResult;

    //1)//Clicking element
    public static void clickElementBy(By by)
    {

        driver.findElement(by).click();
    }
    //2)Clear Text form inout box/area
    public static void clearField(By by)
    {
        driver.findElement(by).clear();
    }

    //3)Enter text in input field
    public static void enterText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //4)Clear and enter text in input field
    public void clearAndEnter(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //5)Checking WebElemnt present in DOM
    public boolean isElementPresent(By by)
    {
        try {
            driver.findElement(by).isEnabled();
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    //6)Checking WebElemnet displayed or not
    public boolean isElementDisplayed(By by)
    {
        try
        {
            driver.findElement(by).isDisplayed();
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    //7)Wait for fixed time given in seconds
    public static void waitForWebElementToBeClickable(WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait( driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //8)Try to click element three times if not available in first go
    public boolean retryForElement(By by)
    {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3)
        {
            try
            {
                Thread.sleep(10);
                driver.findElement(by).click();
                result = true;
                break;
            }
            catch (Exception e)
            {
            }
            attempt++;
        }
        return result;
    }
    //10)Wait for locator to be clickable for given time in seconds
    public static void waitForLocatorToBeClickable(By by, int seconds)
    {
        WebDriverWait wait = new WebDriverWait( driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //11)Wait for visibility of element with given time
    public static void explicitWaitForVisibility(By by, int seconds)
    {
        WebDriverWait wait = new WebDriverWait( driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //12)Timestamp or date in to string conversation
    public static String ShortTimeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("DD.MM.YY");
        Date date = new Date();
        String shortdate = dateFormat.format(date);
        return shortdate;
    }
    //13)Timestamp or date in to string conversation
    public static String LongTimeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("DD.MMM.YYYY.HH.MM.SS");
        Date date = new Date();
        String longdate = dateFormat.format(date);
        return longdate;
    }
    //15)Wait for element to be invisible
    public static void elementToBeInvisible(WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait( driver, seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    //16)Select from visible text
    public static void selectVisibleText(By by, String data)
    {
        Select value = new Select( driver.findElement(by));
        value.selectByVisibleText(data);
    }
    //17)Select from visible Number
    public static void selectVisibleNumber(By by, Integer data)
    {
        Select value = new Select( driver.findElement(by));
        value.selectByIndex(data);
    }
    //18)Select text from value
    public static String getActualText(By by)
    {
        return actualResult =  driver.findElement(by).getText();
    }
    //19)Get selected value from dropdown
    public static void selectByValue(By by, String data)
    {
        Select dob = new Select( driver.findElement(by));
        dob.selectByValue(data);
    }
    //20)Scroll to view element
    public void scrollToElementImplicit(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    //Scroll to element and click
    public void scrollTillElementFoundAndClick(By by, WebElement element)
    {
        ((JavascriptExecutor)  driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(by).click();
    }
    //Wait for alert to display
    public boolean isAlertPresent()
    {
        boolean present = false;
        try {
            // Check the presence of alert
            Alert alert =  driver.switchTo().alert();
            // Alert present; set the flag
            present = true;
            // if present consume the alert
            alert.accept();
        }
        catch (NoAlertPresentException ex)
        {
            // Alert not present
            ex.printStackTrace();
        }
        return present;
    }

    //assert with expected and actual result
    public static void validation(String actualResult)
    {

        Assert.assertEquals(actualResult, expectedResult);
    }


    //hardcoded email with time stamp
    public static void emailWithTimeStamp(By by) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        driver.findElement(by).sendKeys("Test+" + timeStamp + "@home.com");
    }
    //Get attribute of element
    public static String getAttributeOfElement(WebElement element, String attr)
    {
        String value = element.getAttribute(attr);
        return value;
    }
    //Get css property of element
    public String getCssPropOfElement(WebElement element, String css)
    {
        String value = element.getCssValue(css);
        return value;
    }
    //Take screenshot of browser
    public void takeScreenShotOfBrowser(String destination_folder) throws IOException
    {
        File source_folder = ((TakesScreenshot)  driver).getScreenshotAs(OutputType.FILE);
        //File destination_folder = new File ("Destination folder path");
        FileUtils.copyFile(source_folder, new File(destination_folder));
    }
    //Take screenshot of current display (full)
    public void takeScreenShotOfCurrentDisplayFull(String destination_folder) throws IOException
    {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot( driver);
        //File destination_folder = new File("Destination folder path");
        ImageIO.write(screenshot.getImage(), "JPG", new File(destination_folder));
    }
    //Convert date to string
    public String dateToString()
    {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ddmmyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    //Select by text name from dropdown
    public static void selectByText(By by, String data)
    {
        Select dob = new Select( driver.findElement(by));
        dob.selectByVisibleText(data);
    }
    //Select by index value from dropdown
    public static void selectByIndex(By by, Integer data)
    {
        Select dob = new Select( driver.findElement(by));
        dob.selectByIndex(data);
    }
    //Hover over an Element
    public static Actions mouseOverHover(By by) {
        Actions action = new Actions( driver);
        WebElement element =  driver.findElement(by);
        action.moveToElement(element).perform();
        return action;
    }


}
