package ru.merion.aqa.lesson5;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RenameButton {
    private static final String BUTTON_NAME = "Merion";

    @BeforeEach
    public void open(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void iCanRenameTheButton() {
        SelenideElement button = $("#updatingButton");
        open("http://uitestingplayground.com/textinput");
        $("#newButtonName").val(BUTTON_NAME);
        button.click();
        String content = button.text();
        assertEquals(BUTTON_NAME, content);
        System.out.println(content);
    }




}