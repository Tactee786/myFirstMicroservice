package com.tsi.omar.butt.program;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class seleniumTest {
    public static WebDriver driver;
    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    @Test
    @Order(1)
    void checkWebsiteConnection(){
        Assertions.assertDoesNotThrow(() -> {
            driver.get("http://localhost:3000/");
        });
    }
    @Test
    @Order(2)
    void checkActorForm(){
        driver.get("http://localhost:3000/Actor");
        WebElement addId = driver.findElement(By.className("SFAAIField"));
        addId.sendKeys("3");
        WebElement submitButton = driver.findElement(By.className("SFAAISubmit"));
        submitButton.click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/ol"));
        Assertions.assertTrue(element.getText().contains("ID : 3"), "not ID : 3");
        Assertions.assertTrue(element.isDisplayed());
    }
}
