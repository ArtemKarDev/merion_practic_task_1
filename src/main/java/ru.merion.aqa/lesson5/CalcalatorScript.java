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


//                Дождаться результата. Вывести его в консоль.

        //  Открыть страницу
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //  В поле ввода по локатору #delay ввести значение 45
        driver.findElement(By.cssSelector("#delay")).clear();
        driver.findElement(By.cssSelector("#delay")).sendKeys("45");
        //        Нажать на кнопки  7 + 8 =
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        driver.findElement(By.cssSelector("input[name=first-name]")).sendKeys("Иван");
        driver.findElement(By.cssSelector("input[name=last-name]")).sendKeys("Петров");
        driver.findElement(By.cssSelector("input[name=address]")).sendKeys("Ленина, 55-3");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("Москва");
        driver.findElement(By.cssSelector("input[name=country]")).sendKeys("Россия");
        driver.findElement(By.cssSelector("input[name=job-position]")).sendKeys("QA");
        driver.findElement(By.cssSelector("input[name=company]")).sendKeys("Merion");

        //   Нажать кнопку Submit
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // дождаться видимости элемента
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#zip-code"))));
        WebElement element = driver.findElement(By.cssSelector("#zip-code"));
        String color_zip_code = element.getCssValue("background-color");

        //    Вывести его в консоль.
        System.out.println(solution);


        driver.quit();
    }

}