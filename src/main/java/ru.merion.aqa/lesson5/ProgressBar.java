package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;


public class ProgressBar {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60),Duration.ofMillis(100));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressbar"),"75"));
        //String value = driver.findElement(By.cssSelector("#progressbar")).getAttribute("aria-valuenow");

        driver.findElement(By.cssSelector("#stopButton")).click();

        //System.out.println(value);



        driver.quit();

    }
}