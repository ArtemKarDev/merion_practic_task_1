package ru.merion.aqa.lesson5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RenameButton {
    public static void main(String[] args) {
        SelenideElement button = $("#updatingButton");
        open("http://uitestingplayground.com/textinput");
        //        Указать в поле ввода текст "Merion"
        $("#newButtonName").val("Merion");
        //        Нажать на синюю кнопку
        button.click();
        //        Получить текст кнопки и вывести в консоль (Merion)
        String content = button.text();
        //  Вывести его в консоль (”Data loaded with AJAX get request.”)
        System.out.println(content);

    }

}