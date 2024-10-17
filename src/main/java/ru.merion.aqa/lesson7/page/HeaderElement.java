package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderElement {
    private final WebDriver driver;

    private static final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");

    public HeaderElement(WebDriver driver){
        this.driver = driver;
    }

    public ResultPage searchFor(String termin) {
        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        form.findElement(By.cssSelector("#search-field")).sendKeys(termin);
        form.submit();
        return new ResultPage(driver);
    }

    public String getIconText(){
        return driver.findElement(cartIconLocator).getText();
    }

    public CartPage clickCartIcon(){
        driver.findElement(cartIconLocator).click();
        return new CartPage(driver);
    }

}
