package DemoQATest.Elements;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Buttons extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void test(){
        Actions actions = new Actions(driver);

        //double click
        actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        //right click
        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

        //single click
        actions.click(driver.findElement(By.xpath("//button[text() = 'Click Me']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());

    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
