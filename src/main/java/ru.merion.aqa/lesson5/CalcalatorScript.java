package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class CalcalatorScript {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        //  неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  для явного ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //  Открыть страницу
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //  В поле ввода по локатору #delay ввести значение 45
        driver.findElement(By.cssSelector("#delay")).clear();
        driver.findElement(By.cssSelector("#delay")).sendKeys("15");
        //        Нажать на кнопки  7 + 8 =
        driver.findElement(By.xpath("//span[text()=\"7\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"+\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"8\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"=\"]")).click();

        //  Дождаться результата.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.screen"),"15"));
        String solution = driver.findElement(By.cssSelector("div.screen")).getText();
        //    Вывести его в консоль.
        System.out.println(solution);

        driver.quit();
    }

}