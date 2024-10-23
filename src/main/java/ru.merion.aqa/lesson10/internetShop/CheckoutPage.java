package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private SelenideElement continueButton = $(".submit-button");
    private SelenideElement nameFill = $("#first-name");
    private SelenideElement surnameFill = $("#last-name");
    private SelenideElement indexFill = $("#postal-code");

    public CheckoutPage open(){
        Selenide.open("/checkout-step-one");
        return this;
    }

    public CheckoutPage setContactData(String name, String surname, String index){
        nameFill.val(name);
        surnameFill.val(surname);
        indexFill.val(index);
        continueButton.click();
        return this;
    }
    public CartPage clickContinue(){
        continueButton.click();
        return new CartPage();
    }

}
