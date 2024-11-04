package ru.merion.aqa;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver create() {
            return create("chrome");
        }

    public static WebDriver create(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            return create(options);
        }

        if (browserName.equalsIgnoreCase("firefox")){
            return create(new FirefoxOptions());
        }

        throw new IllegalArgumentException("Неподдерживаемый тип браузера " + browserName +" (chrome|firefox)");
    }

    public static WebDriver create(ChromeOptions options){
        return new ChromeDriver(new ChromeOptions().merge(options));
    }

    public static WebDriver create(FirefoxOptions options){
        return new FirefoxDriver(new FirefoxOptions().merge(options));
    }
}