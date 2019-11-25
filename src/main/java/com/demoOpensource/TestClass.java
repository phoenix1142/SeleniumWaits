package com.demoOpensource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String URL = "https://s1.demo.opensourcecms.com/s/44";
    private final String LOGIN_XPATH = "//*[@value='LOGIN']";
    private final String USER = "//*[@name='txtUsername']";
    private final String PASS = "//*[@name='txtPassword']";
    private final String MESSAGE_XPATH = "//*[@id='spanMessage']";

    /**
     * Set Up method
     */
    @Before
    public void setUp() {
         /*
         initialization driver and close enable-automation message
         */
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
          /*
        set explicit wait for driver
         */
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);

    }

    /**
     * check authorization fields and switch between frames on site https://s1.demo.opensourcecms.com/s/44
     */
    @Test
    public void checkSiteDemoOpensourcecms() {
        driver.get(URL);
        driver.switchTo().frame("preview-frame");

        /*
        Wait our elements
         */
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(USER))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PASS))));

        /*
        Fill authorization field
         */
        driver.findElement(By.xpath(USER)).sendKeys("user");
        driver.findElement(By.xpath(PASS)).sendKeys("user");
        driver.findElement(By.xpath(LOGIN_XPATH)).click();

        /*
        check message "Invalid credentials"
         */
        wait.until(ExpectedConditions.textToBe(By.xpath(MESSAGE_XPATH), "Invalid credentials"));
        String invalCredent = driver.findElement(By.xpath(MESSAGE_XPATH)).getAttribute("textContent");
        invalCredent.equals("Invalid credentials");

        /*
        check message "Username cannot be empty"
         */
        driver.findElement(By.xpath(LOGIN_XPATH)).click();
        wait.until(ExpectedConditions.textToBe(By.xpath(MESSAGE_XPATH), "Username cannot be empty"));
        String userCantBeEmpty = driver.findElement(By.xpath(MESSAGE_XPATH)).getAttribute("textContent");
        userCantBeEmpty.equals("Username cannot be empty");

        /*
        check message "Password cannot be empty"
         */
        driver.findElement(By.xpath(USER)).sendKeys("user");
        driver.findElement(By.xpath(LOGIN_XPATH)).click();
        wait.until(ExpectedConditions.textToBe(By.xpath(MESSAGE_XPATH), "Password cannot be empty"));
        String pswdCantBeEmpty = driver.findElement(By.xpath(MESSAGE_XPATH)).getAttribute("textContent");
        pswdCantBeEmpty.equals("Password cannot be empty");

        /*
        Close frame
         */
        driver.switchTo().parentFrame().findElement(By.xpath("//span[contains(.,'Remove Frame')]")).click();

    }

    /**
     *Makes driver quit
     */
    @After
    public void tearDown() {
        driver.quit();
    }

}
