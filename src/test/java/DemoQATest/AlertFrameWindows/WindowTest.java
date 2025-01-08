package DemoQATest.AlertFrameWindows;

import DemoQATest.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowTest extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @Test
    public void test(){
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        Set<String> window = driver.getWindowHandles();
        Iterator<String> itr = window.iterator();
        String parent = itr.next();

        driver.switchTo().window(itr.next());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();

        driver.switchTo().window(itr.next());
        driver.close();

        driver.switchTo().window(parent);

    }
    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
