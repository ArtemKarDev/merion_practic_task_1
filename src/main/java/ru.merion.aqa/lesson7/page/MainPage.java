package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
       super(driver);
    }
    public void open(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.labirint.ru");
        Cookie cookie = new Cookie("cookie_policy","1");
        driver.manage().addCookie(cookie);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru");
    }


}
