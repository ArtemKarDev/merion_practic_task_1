package ru.merion.aqa.lesson5;

import static com.codeborne.selenide.Selenide.*;
public class FillForm {
    public static void main(String[] args) {

        //  Открыть страницу
        open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        //  Заполнить форму значениями
        $("input[name=first-name]").val("Иван");
        $("input[name=last-name]").val("Петров");
        $("input[name=address]").val("Ленина, 55-3");
        $("input[name=city]").val("Москва");
        $("input[name=country]").val("Россия");
        $("input[name=job-position]").val("QA");
        $("input[name=company]").val("Merion");

        //   Нажать кнопку Submit
        $("button[type=submit]").click();
        // дождаться видимости элемента

        String color_zip_code = $("#zip-code").getCssValue("background-color");
        String color_mail =  $("#e-mail").getCssValue("background-color");
        String color_phone = $("#phone").getCssValue("background-color");

        //    Вывести в консоль цвет полей Zip code, E-mail и Phone (background-color)
        System.out.println(color_zip_code);
        System.out.println(color_mail);
        System.out.println(color_phone);

    }

}