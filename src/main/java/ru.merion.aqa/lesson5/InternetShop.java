package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class InternetShop {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.create("chrome");
        //  неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  для явного ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //  Открыть страницу
        driver.get("https://www.saucedemo.com/");
        //        Авторизоваться под пользователем standard_user
        driver.findElement(By.cssSelector("input[name=user-name]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        //         Добавить в корзину товары:
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.inventory_item_description"),"Sauce Labs Backpack"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
        //        Перейти в корзину
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        //        Нажать Checkout
        driver.findElement(By.cssSelector("#checkout")).click();
        //        Заполнить форму данными:
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Иван");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Петров");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("123456");
        //        Нажать continue
        driver.findElement(By.cssSelector("#continue")).click();
        //                Прочитать со стрницы итоговую стоимость ( Total )
        String total = driver.findElement(By.cssSelector("div.summary_total_label")).getText();
        //                Закрыть браузер
        driver.quit();
        //        Вывести в консоль итоговую стоимость ```
        System.out.println(total);

    }

}