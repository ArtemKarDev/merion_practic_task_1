package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.Selenide;

public class CartPage {

    public ru.merion.aqa.lesson10.higherlevel_page.CartPage open() {
        Selenide.open("/cart");
        return this;
    }
}
