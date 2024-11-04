package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Click_on_button4 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание для модального окна
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://the-internet.herokuapp.com/entry_ad");

        // Нажать на кнопку Close
        WebElement closeButton = driver.findElement(By.cssSelector(".modal-footer"));
        closeButton.click();

        // Получить текст элемента с id = content
        WebElement content = driver.findElement(By.id("content"));
        String contentText = content.getText();

        // Вывести текст в консоль
        System.out.println(contentText);

        driver.quit();

    }
}