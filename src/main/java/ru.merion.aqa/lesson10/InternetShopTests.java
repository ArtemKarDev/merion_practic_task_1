package ru.merion.aqa.lesson10;

import com.codeborne.selenide.Configuration;
import ru.merion.aqa.lesson10.internetShop.InventoryPage;
import ru.merion.aqa.lesson10.internetShop.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Set;


public class InternetShopTests {

    public static void main(String[] args) {

        String Login = "standard_user";
        String Pass = "secret_sauce";
        Set<String> itemNames = Set.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie");

        Configuration.browserCapabilities = new ChromeOptions().addArguments("--guest");
        Configuration.baseUrl = "https://www.saucedemo.com";

        LoginPage login;
        InventoryPage catalog;

        login = new LoginPage().open();
        catalog = login.loginAs(Login, Pass);
        catalog.addItems(itemNames);


    }
}