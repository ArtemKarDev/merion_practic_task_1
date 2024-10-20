package ru.merion.aqa.lesson5;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class InternetShop {
    public static void main(String[] args) {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--guest");

        Set<String> itemNames = Set.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie");

        //  Открыть страницу
        open("https://www.saucedemo.com/");
        //        Авторизоваться под пользователем standard_user
        $("input[name=user-name]").val("standard_user");
        $("input[name=password]").val("secret_sauce");
        $("#login-button").click();

        $("div.inventory_item_description").shouldHave(text("Sauce Labs Backpack"));
        //         Добавить в корзину товары:
        $$(".inventory_items").forEach(item -> {
            String productName = item.find(".inventory_item_name").text();
            if (itemNames.contains(productName)) {
                item.find("button").click();
            }
        });

        //        Перейти в корзину
        $("a.shopping_cart_link").click();
        //        Нажать Checkout
        $("#checkout").click();
        //        Заполнить форму данными:
        $("#first-name").val("Иван");
        $("#last-name").val("Петров");
        $("#postal-code").val("123456");
        //        Нажать continue
        $("#continue").click();
        //                Прочитать со стрницы итоговую стоимость ( Total )
        String total = $("div.summary_total_label").text();
        //                Закрыть браузер

        //        Вывести в консоль итоговую стоимость ```
        System.out.println(total);

    }

}