import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait wait;
    private String URL = "https://s1.demo.opensourcecms.com/s/44";
    private String LOGIN_XPATH = "//*[@value='LOGIN']";
    private String USER = "//*[@name='txtUsername']";
    private String PASS = "//*[@name='txtPassword']";

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

    @Test
    /*
1. Вводим любой юзернейт и пароль
2. Кликаем Login
3. Проверяем что появилось сообщение "Invalid credentials"
4. Оставляем пустые поля
5. Кликаем Login
6. Проверяем что появилось сообщение "Username cannot be empty"
7. Запонляем юзернейм
8. Кликаем Login
9. Проверяем что появилось сообщение "Password cannot be empty"
10. Кликаем в верхнем правом углу на "Remove frame"
11. Проверяем что фрейм пропал.
     */
    public void openDemo() {
        driver.get(URL);




//        WebElement waitLogin = (new WebDriverWait(driver,10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER)));
//
//        WebElement waitPass = (new WebDriverWait(driver,10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASS)));





//        wait.until(ExpectedConditions.and(
//                ExpectedConditions.elementToBeClickable(By.xpath(USER)),
//                ExpectedConditions.textToBe(By.xpath(USER), "login")));
//
//        wait.until(ExpectedConditions.and(
//        ExpectedConditions.elementToBeClickable(By.xpath(PASS)),
//                ExpectedConditions.textToBe(By.xpath(PASS), "pass")));

//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='txtUsername']"))));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='txtPassword']"))));



//        driver.findElement(By.xpath("//*[@name='txtUsername']")).click();
//        driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("pass");
//        driver.findElement(By.xpath(LOGIN_XPATH)).click();


//        wait.until(ExpectedCondition.textToBe(By.xpath("//span[@id='spanMessage']")));
//        wait.until(driver.findElement(By.xpath("//span[@id='spanMessage']")).getAttribute(equals(message));


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
