package ru.merion.aqa.lesson5;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;


public class WaitImg {
    public static void main(String[] args) {

        //  Открыть страницу
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        //        Дождаться загрузки 3й картинки
        ElementsCollection images = $$("#image-container img").shouldHave(CollectionCondition.sizeGreaterThan(2),Duration.ofSeconds(10));
        //       Получить значение атрибута src у 3й картинки
        String content = images.get(2).getAttribute("src");
        //     Вывести его в консоль
        System.out.println(content);

    }

}