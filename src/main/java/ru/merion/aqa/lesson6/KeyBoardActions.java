package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.merion.aqa.WebDriverFactory;

public class KeyBoardActions {
    public static void main (String[] args){

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textInput");

        By locator = By.cssSelector("#newButtonName");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WIN10) ? Keys.COMMAND : Keys.CONTROL;

        long pause = 1L;
        new Actions(driver)
                .keyDown(Keys.LEFT_SHIFT)
                .sendKeys(driver.findElement(locator), "merion")
                .keyUp(Keys.LEFT_SHIFT)
                .pause(pause)
                .keyDown(Keys.LEFT_SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.LEFT_SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("c")
                .pause(pause)
                .sendKeys("vv")
                .pause(pause)
                .sendKeys("v")
                .keyUp(cmdCtrl)
                .pause(pause)
                .perform();

        driver.quit();

    }


}
