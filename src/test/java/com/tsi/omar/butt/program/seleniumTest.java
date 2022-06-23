package com.tsi.omar.butt.program;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("ID")));
        Assertions.assertTrue(element.getText().contains("ID : 3"), "not ID : 3");
        Assertions.assertTrue(element.isDisplayed());
    }
    @Test
    @Order(3)
    void goToActionCategory(){
        driver.get("http://localhost:3000/Film/Categories");
        WebElement actionLink = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        actionLink.click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.className("AFBCcategory")));
        Assertions.assertTrue(element.isDisplayed());
    }
    @Test
    @Order(4)
    void searchFilmByName(){
        driver.get("http://localhost:3000/Film");
        WebElement addId = driver.findElement(By.className("SFAAIField"));
        addId.sendKeys("Alice");
        WebElement submitButton = driver.findElement(By.className("SFAAISubmit"));
        submitButton.click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        Assertions.assertTrue(element.getText().contains("ALICE FANTASIA"), "not ALICE FANTASIA");
        Assertions.assertTrue(element.isDisplayed());
    }
}
