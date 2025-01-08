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

public class Frames extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @Test
    public void test() {
        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        //Nested Frames
        driver.findElement(By.xpath("//span[text() = 'Nested Frames']")).click();
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.switchTo().defaultContent();
    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
