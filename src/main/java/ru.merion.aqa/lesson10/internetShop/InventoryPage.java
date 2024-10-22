package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Configuration.*;

public class InventoryPage {
    Configuration.browserCapabilities = new ChromeOptions().addArguments("--guest");

}
