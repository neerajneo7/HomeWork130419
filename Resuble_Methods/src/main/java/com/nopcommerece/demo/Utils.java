package com.nopcommerece.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage
{

    //Clicking element
    public static void elementShouldBeClickable(By by)
    {
        try
        {
            driver.findElement(by).click();
        }
        catch(ElementClickInterceptedException e)
        {
            throw e;
        }
    }

    //Clear Text form inout box/area
    public static void clearTextFromInoutBoxOrArea(By by)

    {
        driver.findElement(by).clear();
    }

    //Enter text in input field
    public static void enterTextInTheField(By by, String text)

    {
        driver.findElement(by).sendKeys(text);
    }

    //Clear and enter text in input field
    public static void clearAndEnterTextInTheField(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }



    //Checking WebElemnt present in DOM
    public static void checkWebElementPresent(By by)
    {

        if (driver.findElement(by).isDisplayed())
        {
            //Since, no exception, so element is present
            System.out.println("Element is present");
        } else  {
            //Element is not present
            System.out.println("Element is not present");
                }
    }


//        Checking WebElement displayed or not
    public static boolean checkWebElementIsDisplayed(By by)
    {
        return driver.findElement(by).isDisplayed();

    }


    //Wait for fixed time given in seconds. Implicit Wait
    public static void implicityWaitForTheElements()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


   //Try to click element three times if not available in first go
    public static void clickOnElementThreeTimes(By by)
    {

            //driver.findElement(by).isDisplayed();
            if (driver.findElement(by).isDisplayed())
            {
                driver.findElement(by).click();

            }else if(driver.findElement(by).isDisplayed())
                {
                    driver.findElement(by).click();
                }
             else if(driver.findElement(by).isDisplayed())
                {
                    driver.findElement(by).click();
                }
            else
                {
                    System.out.println("Element is not clickable");
                }
    }


        //is drop down present
        public static void dropDownElementPresentOrNot(By by, String text)
        {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);
        }


    //Wait for locator to be clickable for given time in seconds
    public static void waitForTheLocatorToBeClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Wait for Elements to be clickable for given time in seconds
    public static void waitForTheElementToBeClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.elementToBeClickable(by)));
    }

    //Date stamp short
    public static void dateStampShort()
    {
        Date shortdate = new Date();
        String strDateFormat = "dd/MMM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println("Current Time : " + sdf.format(shortdate));
    }

    //Date stamp long
    public static void dateStampLong()
    {
        Date longDate = new Date();// Current System Date and Time is assigned to the object Date
        String strDateFormat = "E, dd MMM yyyy  hh:mm:ss  a  zz ";// Date format is specified
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
        System.out.println("Current Time and Date : " + sdf.format(longDate));
    }


    //Wait for the element for given time in seconds
    public static void waitForElementForGivenTime(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        // this will wait for given time for the element until it has been loaded or located.
    }


    //Wait for the element to be invisible
    public static void waitForTheElementToBeInvisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        // this will wait for given time for the element until it is invisible.
    }

    //Select from visible text
    public static void selectFromVisibleText(By by, String text)
    {

        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
        //The method selects the option by its visible option tag value. It accepts the visible text value of the option tag and returns nothing.
    }


    //Select from visible number
    public static void selectFromVisibleNumber(By by, int num)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByIndex(num);
        //The method selects the option by Zero based INDEX value passed as an integer parameter.

    }
    //Select from value
    public static void selectFromValue(By by, String text)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByValue(text);
        //The method selects the option based on the VALUE attribute value of option tag.
        // It accepts the VALUE attribute value as a string, selects the option tag with passed value, and returns nothing.
    }


    //Get Selected Value From Dropdown
    public static void selectValueFromDropdown(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
        select.selectByValue(value);

    }

    //Scroll to view Element
    public static void scrollToViewElement(By by)
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(by);
        jse.executeScript("argument[0].scrollIntoView(true);", element);
        //this method wil only work if applied directly to your project. You cannot call this as a method.

    }

    //Scroll to element and click
    public static void scrollToElementAndClick(By by)
    {

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(by).click();
    }

    //Wait for Alert To Display
    public static void waitForAlertToDisplay(int time)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("Alert box text " + alert.getText());
            alert.accept();
        }
        catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();
        }

    }


    //Get attribute of an element
    public static void getAttributeOfAnElement(By by, String value)

    {
        driver.findElement(by).getAttribute(value);
    }

    //Get CSS property of an element
    public static void getCssPropertyOfAnElement(By by, String value)

    {
        driver.findElement(by).getCssValue(value);
    }


    //Take screenshot of the browser
    public static void screenshotOfTheBrowser()
    {
        //This takes the screen shot of the browser and will store the image in specified location
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screen, new File("C:\\Screenshot\\Browsershot.png"));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }

    //Take screenshot of full display(full)
    public static void screenshotOfFullCurrentDisplay()
    {
        Screenshot fpScreenshot = new AShot ().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try
        {
            ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\Screenshot\\FullPageScreenshot.png"));
        } catch (IOException e)
        {
            e.printStackTrace ( );
        }
    }

}
