package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private static final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.findElement(cartIconLocator);
    }

    public void checkCartCounter() {
        String cartCounter = driver.findElement(By.cssSelector("#basket_default-prod-counter2")).getText();
        System.out.println("Счетчик товаров в корзине = "+ cartCounter);
    }

    public void checkCartPrice() {
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText();
        System.out.println("Цена = " + price);
    }


}
