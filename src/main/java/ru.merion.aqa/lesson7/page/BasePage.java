package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;

    public static HeaderElement header;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderElement(driver);
    }
}
