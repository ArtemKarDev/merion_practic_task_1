package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginInpput = $("input[name=user-name]");
    private final SelenideElement passInpput = $("input[name=password]");
    private final SelenideElement loginButton = $("#login-button");

    public void loginSet(String login) {
        loginInpput.val(login);
    }
    public void passSet(String pass) {
        passInpput.val(pass);
    }
    public void loginPush(){
        loginButton.click();
    }
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public InventoryPage loginAs(String login, String pass) {
        Selenide.open("/");
        loginSet(login);
        passSet(pass);
        loginPush();
        return new InventoryPage();
    }

}
