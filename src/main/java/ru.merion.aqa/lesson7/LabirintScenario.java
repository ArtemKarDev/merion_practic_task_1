package ru.merion.aqa.lesson7;

import org.openqa.selenium.*;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintScenario {

    static WebDriver driver;
    private static final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart")
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.searchFor("Java");

        ResultPage resultPage = new ResultPage(driver);
        resultPage.addAllItemsToCart();
        resultPage.checkIconText();

        CartPage cartPage = new CartPage(driver);
        cartPage.open();
        cartPage.checkCartCounter();
        cartPage.checkCartPrice();

        driver.quit();


    }




}
