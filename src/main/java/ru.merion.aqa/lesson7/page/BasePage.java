package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;

    public static HeaderElement header;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        WebElement header = driver.findElement(By.cssSelector(".top-header"));
        this.header = PageFactory.initElements(header, HeaderElement.class);
    }
}
