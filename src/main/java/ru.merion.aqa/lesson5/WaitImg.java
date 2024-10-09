package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class WaitImg {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.create("chrome");
        //  неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  для явного ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        //  Открыть страницу
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        //        Дождаться загрузки 3й картинки
        List<WebElement> elements = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#image-container img"), 3));
        //       Получить значение атрибута src у 3й картинки
        String content = elements.get(2).getAttribute("src");
        //     Вывести его в консоль
        System.out.println(content);

        driver.quit();
    }

}