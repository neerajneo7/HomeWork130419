package com.nopcommerece.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReusableMethodsForNopWebsite extends Utils {
    @Before //this will be executed before every test run
    public void setup() {
        // this is to setup your path to the chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\com\\nopcommerece\\demo\\BrowserDriver\\chromedriver.exe");
        // this is to create the object for your driver which is in the class
        driver = new ChromeDriver();

        // this is to manage your Implicity wait for 20 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // this is the website you want to visit for your testing purposes
        driver.get("https://demo.nopcommerce.com/");

        // this is to maximise your browser window
        driver.manage().window().maximize();


    }

    @After // this will be executed after every Test run
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void registration() {

        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String Date1 = dateFormat.format(date);


        // to click on Register button on homepage
        elementShouldBeClickable(By.xpath("//a[@class='ico-register']"));


//        waitMethodForTheElements(By.id("gender-male"), 10);

        // to select the gender using id....
        elementShouldBeClickable(By.id("gender-male"));

        //to Enter the First Name using xpath
        enterTextInTheField(By.xpath("//input[@id='FirstName']"), "Neeraj123");

        // to Enter Last Name using id
        //driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Arora1122");
        enterTextInTheField(By.xpath("//input[@id='LastName']"), "Arora1122");

        // Enter DOB using xpath. Enter the date first
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("10");


       // enter the month
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("October");


       // enter the year
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1910");


        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("neo" + date + "@neo.com");
        //enter Company Name
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Indian Tigers");
        //enter password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("neoneoneo");
        //verify password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("neoneoneo");

        //click on register button
        driver.findElement(By.xpath("//input[@id='register-button']")).click();

        //this is to match up your expected results = actual results using class name in find Elements
        String ActualResult = driver.findElement(By.className("result")).getText();

         /* this is the assert syntax to match up your results.
         In some cases Assert will come up as RED so type @Test in the main class and download the jar file for junit
          */
        Assert.assertEquals("Your registration completed", ActualResult);
        System.out.println("Expected Result : Your registration completed = Actual Result : " + ActualResult);

        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
    }


    @Test
    public void navigateToNotebookCategoryPage() {
        //User should be able to navigate to Notebook category page(Computer>>Notebooks)
        //this is by using xpath
        driver.findElement(By.xpath("//a[@href='/computers']")).click();
        driver.findElement(By.xpath("(//a[@href='/notebooks'])[3]")).click();

    }
    //
//    @Test
//    public void hooverMethodToNavigateToNotebookPage() {
//        //User should be able to navigate to Notebook category page(Computer>>Notebooks)
//        //this is by using hoover method
//        WebElement element = driver.findElement(By.linkText("Computers"));
//        Actions action = new Actions(driver);
//        action.moveToElement(element).build().perform();
//        driver.findElement(By.linkText("Notebooks")).click();
//
//        String actualResult = driver.getCurrentUrl();
//        Assert.assertEquals("https://demo.nopcommerce.com/notebooks", actualResult);
//        System.out.println("Expected Result : https://demo.nopcommerce.com/notebooks = Actual Result : " + actualResult);
////


    @Test
    public void navigateToCellPhonePage() {
        //User should be able to navigate cell phone page via Electronics>>Cellpohone

        driver.findElement(By.xpath("(//a[@href='/electronics'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='/cell-phones'])[3]")).click();

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/cell-phones", actualResult);
        System.out.println("Expected Result : https://demo.nopcommerce.com/cell-phones = Actual Result : " + actualResult);
    }


    @Test
    public void userShouldBeAbleToLogin() {


        //User should be able to login Successfully.
        // I have used the hardcoded email and password to login

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.className("email")).sendKeys("neo@neo.com");
        driver.findElement(By.id("Password")).sendKeys("neoneoneo");
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

        String actualResult = driver.findElement(By.xpath("//a[@href='/logout']")).getText();
        Assert.assertEquals("Log out", actualResult);
        System.out.println("Expected Result : Log out = Actual Result : " + actualResult);
    }

    @Test(timeout = 20000)
    // by using timeout, it will come out of the webpage after the specified time.
    //time is in millisecond.

    public void addProductToShoppingCart() {
        // user should be able to add a product to the shopping cart
        driver.findElement(By.xpath("(//a[@href='/electronics'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='/cell-phones'])[3]")).click();
        driver.findElement(By.xpath("//a[@href='/htc-one-m8-android-l-50-lollipop']")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-18']")).click();
        //driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        //I have taken the actual product description to match up the expected results
        String actualproductincart = driver.findElement(By.xpath("(//a[@href='/htc-one-m8-android-l-50-lollipop'])[4]")).getText();
        Assert.assertEquals("HTC One M8 Android L 5.0 Lollipop", actualproductincart);
        System.out.println("Expected Product : HTC One M8 Android L 5.0 Lollipop = Actual Product : " + actualproductincart);

    }
@Test
    public void screen()
        {
            elementShouldBeClickable(By.xpath("//a[@class='ico-register']"));
            selectFromVisibleNumber(By.xpath("//select[@name='DateOfBirthDay']"), 10);
        }

}
