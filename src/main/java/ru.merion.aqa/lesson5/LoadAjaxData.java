package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class LoadAjaxData {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.cssSelector("#ajaxButton")).click();
        String content = driver.findElement(By.cssSelector("#content p")).getText();

        System.out.println(content);



        driver.quit();

    }
}