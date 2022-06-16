package com.tsi.omar.butt.program;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class seleniumTest {
    public WebDriver driver;
    @Test
    public void chromeDriverTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void chromeSessionTest(){
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.quit();
    }

    @Test
    public void checkWebsiteConnection(){
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.quit();
    }

    @Test
    public void checkActorForm(){
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/Actor");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement addId = driver.findElement(By.className("SFAAIField"));
        addId.sendKeys("3");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement submitButton = driver.findElement(By.className("SFAAISubmit"));
        submitButton.click();
        driver.quit();
    }
}
