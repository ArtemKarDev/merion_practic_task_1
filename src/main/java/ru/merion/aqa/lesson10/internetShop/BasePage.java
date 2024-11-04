package ru.merion.aqa.lesson10.internetShop;

public abstract class BasePage {


    public BasePage() {
        this.header = new HeaderElement();
    }

    private HeaderElement header;

    public HeaderElement header(){
        return this.header;
    }
}
