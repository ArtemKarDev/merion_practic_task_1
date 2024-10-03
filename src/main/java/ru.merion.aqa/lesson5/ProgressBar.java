package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;


public class ProgressBar {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        String value = driver.findElement(By.cssSelector("#progressbar")).getAttribute("aria-valuenow");

        driver.findElement(By.cssSelector("#stopButton")).click();

        System.out.println(value.equals("75"));



        driver.quit();

    }
}