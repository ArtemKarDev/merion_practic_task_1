package ru.merion.aqa.lesson5;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class CalculatorScript {
    public static void main(String[] args) {
        int timeout = 6;
        //  Открыть страницу
        open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //  В поле ввода по локатору #delay ввести значение timeout
        $("#delay").val(Integer.toString(timeout));
        //        Нажать на кнопки  7 + 8 =
        $x("//span[text()=\"7\"]").click();
        $x("//span[text()=\"+\"]").click();
        $x("//span[text()=\"8\"]").click();
        $x("//span[text()=\"=\"]").click();
        //  Дождаться результата.
        $("div.screen").shouldHave(text("15"));
        // вариант 2
        //$("#spinner").shouldNotBe(visible,Duration.ofSeconds(timeout+1));
        String solution = $("div.screen").getText();
        System.out.println(solution);

    }

}