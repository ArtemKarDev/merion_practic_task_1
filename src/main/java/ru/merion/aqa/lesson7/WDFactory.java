package ru.merion.aqa.lesson7;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WDFactory {


    public static WebDriver create() {
        return create("chrome");
    }

    public static WebDriver create(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            return create(new ChromeOptions());
        }

        if (browserName.equalsIgnoreCase("firefox")){
            return create(new FirefoxOptions());
        }

        throw new IllegalArgumentException("Неподдерживаемый тип браузера " + browserName +" (chrome|firefox)");
    }

    public static WebDriver create(ChromeOptions options){
        WebDriver driver = new ChromeDriver(new ChromeOptions().merge(options));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.labirint.ru");
        Cookie cookie = new Cookie("cookie_policy","1");
        driver.manage().addCookie(cookie);
        driver.manage().window().maximize();
        return  driver;
    }

    public static WebDriver create(FirefoxOptions options){
        return new FirefoxDriver(new FirefoxOptions().merge(options));

    }

}



