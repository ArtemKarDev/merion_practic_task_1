package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(css = "h1")
    private WebElement emptyResultMessage;
    @FindBy(css = ".product-card")
    List<WebElement> cards;
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void addAllItemsToCart(){
        int counter = 0;
        for (WebElement card : cards) {
            card.findElement(By.cssSelector(".buy-link")).click();
            counter++;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(header.getCardIcon(), String.valueOf(counter)));
    }



//    public String getEmptyResultMessage(){
//        return emptyResultMessage();
//    }
}
