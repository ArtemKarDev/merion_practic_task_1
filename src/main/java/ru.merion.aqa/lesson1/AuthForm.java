package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class AuthForm {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Открыть страницу
        driver.get("http://the-internet.herokuapp.com/login");

        // Найти поля ввода
        WebElement inputUser = driver.findElement(By.cssSelector("#username"));
        WebElement inputPass = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".fa-sign-in"));

        inputUser.sendKeys("tomsmith");
        inputPass.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement flashMessages = driver.findElement(By.cssSelector("#flash"));
        String contentText = flashMessages.getText();
        System.out.println(contentText);

        driver.quit();

    }
}