package ru.merion.aqa.lesson7;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class LabirintScenario {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.labirint.ru");
        Cookie cookie = new Cookie("cookie_policy","1");
        driver.manage().addCookie(cookie);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru");

        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        form.findElement(By.cssSelector("#search-field")).sendKeys("Java", Keys.RETURN);
        form.submit();






        driver.quit();


    }
}
