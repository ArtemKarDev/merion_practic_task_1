package ru.merion.aqa.lesson10.internetShop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.$$;


public class InventoryPage {
    private final ElementsCollection items = $$(".inventory_item");

    public InventoryPage open(){
        Selenide.open("/inventory");
        return this;
    }

    public void addItems(Collection<String> itemNames){
        items.forEach(item -> {
            String productName = item.find(".inventory_item_name").text();
            if (itemNames.contains(productName)){
                item.find("button").click();
            }
        });

    }

}
