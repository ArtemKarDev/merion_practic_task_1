package ru.merion.aqa.lesson7;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class LabirintScenario {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        // открыть страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.labirint.ru");
        Cookie cookie = new Cookie("cookie_policy","1");
        driver.manage().addCookie(cookie);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru");

        // выполнить поиск
        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        form.findElement(By.cssSelector("#search-field")).sendKeys("Java", Keys.RETURN);
        form.submit();

        // добавить товары
        List<WebElement> cards = driver.findElement(By.cssSelector(".product-card"));
        for (WebElement card : cards) {
            card.findElement(By.cssSelector(".buy-link")).click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".b-header-b-personal-e-icon-count-m-cart"), "60"));

        // посмотреть иконку
        WebElement cartIcon = driver.findElement(By.cssSelector(".b-header-b-personal-e-icon-count-m-cart"));
        String cartIconCounter = cartIcon.getText();
        System.out.println("Счетчик товаров в иконке Корзина = "+ cartIconCounter);
        // перейти в корзину
        cartIcon.click();
        // посмотреть счетчик
        String cartCounter = driver.findElement(By.cssSelector("#basket_default-prod-counter2")).getText();
        System.out.println("Счетчик товаров в корзине = "+ cartCounter);

        // посмотреть цену
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText();
        System.out.println("Цена = " + price);



        driver.quit();


    }
}
