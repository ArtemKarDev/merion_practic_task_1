package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(css="#basket_default-prod-counter2")
    private WebElement productCounter;
    @FindBy(css="#basket-default-sumprice-discount")

    private WebElement totalPrice;

    private static final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartCounter() {
        return productCounter.getText();
    }

    public String getCartPrice() {
        return totalPrice.getText();
    }


}
