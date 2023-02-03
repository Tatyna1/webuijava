package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String AFISHA_BASE_URL = "https://www.afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AFISHA_BASE_URL);
    }

    @Test
    void likeMovieTest() {
        webDriverWait.until(
                d -> d.findElements(
                        By.xpath("//a[@data-test='LINK ITEM-URL' and contains(@href, 'movie')]/h2")).size() > 0);
        List<WebElement> filmlist = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-URL' and contains(@href, 'movie')]/h2"));
//        filmlist.stream().filter(f -> f.getText().contains("Реальные упыри")).findFirst().get().click();
        filmlist.get(0).click();


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(),true);
    }

    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[.='Подписаться']")));
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//header//a[.='СКОРО ОНЛАЙН В ОККО']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
