package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Click_on_button3 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        // 1. Открыть страницу
        driver.get("http://uitestingplayground.com/classattr");

        // 2. кликнуть на кнопку
        WebElement addButton = driver.findElement(By.cssSelector(".btn.btn-primary"));

        driver.quit();
    }
}