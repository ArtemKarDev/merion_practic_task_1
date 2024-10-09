package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class RenameButton {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        //  неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  Открыть страницу
        driver.get("http://uitestingplayground.com/textinput");
        //        Указать в поле ввода текст "Merion"
        //driver.findElement(By.cssSelector("#newButtonName")).clear();
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Merion");
        //        Нажать на синюю кнопку
        driver.findElement(By.cssSelector("#updatingButton")).click();
        //        Получить текст кнопки и вывести в консоль (Merion)
        String content = driver.findElement(By.cssSelector("#updatingButton")).getText();
        //  Вывести его в консоль (”Data loaded with AJAX get request.”)
        System.out.println(content);

        driver.quit();
    }

}