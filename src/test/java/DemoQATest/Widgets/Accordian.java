package DemoQATest.Widgets;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Accordian extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/accordian");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
    @Test
    public void test() throws InterruptedException {
        System.out.println(driver.findElement(By.id("section1Content")).findElement(By.xpath("./p")).getText());
        Thread.sleep(2000);
        driver.findElement(By.id("section2Heading")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("section2Content")).findElements(By.xpath("./p")).get(0).getText());
        System.out.println(driver.findElement(By.id("section2Content")).findElements(By.xpath("./p")).get(1).getText());
        driver.findElement(By.id("section3Heading")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("section3Content")).findElement(By.xpath("./p")).getText());

    }
}



