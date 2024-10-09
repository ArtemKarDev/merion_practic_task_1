package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;


public class ECDemo {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // дождаться исчезнвения элемента
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // дождаться точного количества элкементов на странице
        List<WebElement> elements = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 7));
        elements.clear();
        // дождаться видимости элемента
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("")))).click();

        // дождаться появления alert/confirm/prompt и перейти в него
        wait.until(ExpectedConditions.alertIsPresent());

        // дождаться отсутствия или скрытия элемента
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(""))));

        // дождаться наличия элемента в DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // дождаться что атрибут элемента содержит значение
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(""), "class", "btn-success"));

        // проверить что title страницы содержит подстроку
        wait.until(ExpectedConditions.titleContains("Входящие(3)"));

        // проверить что title страницы равено строке
        wait.until(ExpectedConditions.titleIs("Входящие(3)"));

        // проверить что url страницы содержит подстроку
        wait.until(ExpectedConditions.urlContains("..."));

        // объединить ожидания
        wait.until(ExpectedConditions.and(ExpectedConditions.alertIsPresent(),ExpectedConditions.urlToBe("")));

        // проверить что элемент не выбран
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));

        // проверить что элемент кликабельный (видимы и enabled)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // проверить что элементов на странице строго больше чем ...
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""), 7));

        // дождаться хотябы одно условие
        wait.until(ExpectedConditions.or(ExpectedConditions.alertIsPresent(),ExpectedConditions.urlToBe("")));

        // дождаться что элемент содержит в тексте подстроку
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(""), ""));

        // дождаться в атрибуте value  подстроку
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector(""),""));



        driver.quit();

    }
}