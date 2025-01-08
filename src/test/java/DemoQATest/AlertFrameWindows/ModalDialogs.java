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

public class ModalDialogs extends BaseClass {
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
        driver.findElement(By.id("showSmallModal")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'modal-content']")));
        System.out.println(driver.findElement(By.xpath("//div[@class = 'modal-body']")).getText());
        driver.findElement(By.id("closeSmallModal")).click();

        driver.findElement(By.id("showLargeModal")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'modal-content']")));
        System.out.println(driver.findElement(By.xpath("//div[@class = 'modal-body']/p")).getText());
        driver.findElement(By.id("closeLargeModal")).click();

    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
