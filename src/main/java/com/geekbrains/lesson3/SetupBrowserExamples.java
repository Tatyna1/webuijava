package com.geekbrains.lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        chromeOptions.addArguments("--headles");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");

        driver.quit();




    }
}
