package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://ya.ru");

        driver.quit();
        firefoxDriver.quit();

    }

}