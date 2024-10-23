package ru.merion.aqa.lesson10.higherlevel_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {
    private final SelenideElement searchInpput = $("#search-field");

    public ResultPage searchFor(String term) {
        searchInpput.val(term).pressEnter();
        return new ResultPage();
    }
}
