package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class InputPlace {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://the-internet.herokuapp.com/inputs");

        // Найти поле ввода
        WebElement inputPlace = driver.findElement(By.cssSelector("input[type=number]"));
        inputPlace.click();
        inputPlace.sendKeys("1000");
        inputPlace.clear();
        inputPlace.sendKeys("2000");

        driver.quit();

    }
}