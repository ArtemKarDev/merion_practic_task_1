package ru.merion.aqa.lesson5

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.nio.file.Path
import java.time.Duration

import ru.merion.aqa.lesson5.CustomEC.*;

public class CustomECDemo {

    public static void main(String[] args) {
        Path relativPath = Path.of("src/main/resources/dummy_pages/old_vk.html");
        String filePath = Paths.get("").toAbsolutePath().resolve(reletionPath).toString();

        WebDriver driver = WebDrierFactory.create();
        driver.get("file://" + filePath);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(1));
        wait.until(textContainAfterRefresh(By.ByCssSelector("#msg_counter"), "(1)"));

        String txt = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(txt); // Входящие (1)

        driver.quit();

    }
}