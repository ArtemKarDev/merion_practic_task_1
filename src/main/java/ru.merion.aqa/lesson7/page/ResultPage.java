package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage extends BasePage {
    private static final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void addAllItemsToCart(){
        int counter = 0;
        List<WebElement> cards = driver.findElement(By.cssSelector(".product-card"));
        for (WebElement card : cards) {
            card.findElement(By.cssSelector(".buy-link")).click();
            counter++;
        }
        // TODO: move too header
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(cartIconLocator, String.valueOf(counter)));
    }



    public void checkEmptyResult(){
        String message = driver.findElement(By.cssSelector("h1")).getText();
        System.out.println(message);
    }
}
