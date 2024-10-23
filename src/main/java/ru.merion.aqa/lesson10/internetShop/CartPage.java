package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement totalPrice = $("div.summary_total_label");

    public CartPage open() {
        Selenide.open("/cart");
        return this;
    }

    public String getResultPrice(){
        return totalPrice.getText();
    }

    public CheckoutPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutPage();
    }
}
