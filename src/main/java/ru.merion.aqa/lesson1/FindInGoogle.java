package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class FindInGoogle {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("https://www.google.com");

        // Найти поля ввода
        WebElement inputGoogle = driver.findElement(By.cssSelector("textarea[name=q]"));

        inputGoogle.sendKeys("Merion Academy wiki");
        inputGoogle.sendKeys(Keys.RETURN);

        // Ожидание и клик по первой ссылке из результатов поиска
        WebElement firstResult = driver.findElements(By.cssSelector("h3")).get(0);
        firstResult.click();

        // Получение текущего URL
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.startsWith("https://wiki.merionet.ru")) {
            System.out.println("Добро пожаловать в Merion Academy!.");
        } else {
            System.out.println("Мы попали куда-то не туда...");
        }

        driver.quit();

    }
}