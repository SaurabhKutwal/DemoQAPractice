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

public class AlertsTest extends BaseClass {

    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @Test
    public void test() {
        driver.findElement(By.id("alertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmResult")));
        System.out.println(driver.findElement(By.id("confirmResult")).getText());

        driver.findElement(By.id("promtButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Master panda");
        alert.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptResult")));
        System.out.println(driver.findElement(By.id("promptResult")).getText());

    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
