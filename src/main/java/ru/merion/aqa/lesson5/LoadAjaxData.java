package ru.merion.aqa.lesson5;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoadAjaxData {
    public static void main(String[] args) {

    //  Открыть страницу
        open("http://uitestingplayground.com/ajax");
    //  Нажать на синюю кнопку
        $("#ajaxButton").click();
    //  Получить текст из зеленой плашки
        String content = $("#content p")
                .shouldBe(visible, Duration.ofSeconds(16))
                .getText();
    //  Вывести его в консоль (”Data loaded with AJAX get request.”)
        System.out.println(content);

    }
}