package ru.merion.aqa.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Click_on_button {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        // 1. Открыть страницу
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // 2. 5 раз кликнуть на кнопку Add Element
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < 5; i++) {
            addButton.click();
        }

        // 3. Собрать со страницы список кнопок Delete
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));

        // 4. Вывести на экран размер списка
        System.out.println("Количество кнопок Delete: " + deleteButtons.size());

        driver.quit();
    }
}