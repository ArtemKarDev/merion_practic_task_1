package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class LoadAjaxData {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        //  неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  Открыть страницу
        driver.get("http://uitestingplayground.com/ajax");
        //  Нажать на синюю кнопку
        driver.findElement(By.cssSelector("#ajaxButton")).click();
        //  Получить текст из зеленой плашки
        String content = driver.findElement(By.cssSelector("#content p")).getText();
        //  Вывести его в консоль (”Data loaded with AJAX get request.”)
        System.out.println(content);

        driver.quit();

    }
}