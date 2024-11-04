package ru.merion.aqa.lesson10;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import ru.merion.aqa.lesson10.internetShop.CartPage;
import ru.merion.aqa.lesson10.internetShop.CheckoutPage;
import ru.merion.aqa.lesson10.internetShop.InventoryPage;
import ru.merion.aqa.lesson10.internetShop.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InternetShopTests {

    @Test
    public static void main(String[] args) {

        String Login = "standard_user";
        String Pass = "secret_sauce";
        Set<String> itemNames = Set.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie");
        String name = "Ivan", surname = "Ivanov", index = "123456";

        Configuration.browserCapabilities = new ChromeOptions().addArguments("--guest");
        Configuration.baseUrl = "https://www.saucedemo.com";

        LoginPage login;
        InventoryPage catalog;
        CartPage cart;
        CheckoutPage checkout;

        login = new LoginPage().open();
        catalog = login.loginAs(Login, Pass);
        catalog.addItems(itemNames);
        cart = catalog.cartIn();
        checkout = cart.clickCheckout();
        cart = checkout.clickContinue();

        String result = cart.getResultPrice();

        assertTrue(result.endsWith("55.29"));

    }
}