package DemoQATest.Widgets;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.crypto.KEM;
import java.time.Duration;
import java.util.List;

public class AutoComplete extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/auto-complete");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }

    @Test
    public void test() throws InterruptedException {
        List<String> colors = List.of("Red","White","Black","Green");
        for(String color : colors){
            driver.findElement(By.id("autoCompleteMultipleInput")).sendKeys(color);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'auto-complete__menu css-26l3qy-menu']")));
            driver.findElement(By.xpath("//div[text() = '"+color+"']")).click();
        }

        Thread.sleep(2000);
    }
}
