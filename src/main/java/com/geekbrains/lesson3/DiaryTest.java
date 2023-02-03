package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");
        WebElement loginForm = driver.findElement(By.id("loginform-username"));
        loginForm.sendKeys("m_mary_987");
        driver.findElement(By.id("loginform-password")).sendKeys("Asti123!");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        driver.switchTo().parentFrame();

        driver.findElement(By.id("login_btn")).click();

        driver.findElement(By.id("writeThisDiary")).click();

        String postTitle = "test" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys("postTitle");

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("tttwwwtwtwtwt");
        driver.switchTo().parentFrame();

        driver.findElement(By.id("rewrite")).click();

        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@class='title']"));
        postTitles.stream().filter(p -> p.getText().contains(postTitle)).findFirst().get().click();

        Thread.sleep(5000);

        driver.quit();



    }
}
