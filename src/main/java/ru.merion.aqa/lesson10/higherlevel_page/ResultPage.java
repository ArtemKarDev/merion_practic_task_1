package ru.merion.aqa.lesson10.higherlevel_page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    private final ElementsCollection cards = $$(".product-card .buy-link");

    public void addAllItemsToCart(){
        cards.forEach(SelenideElement::click);

    }


}
