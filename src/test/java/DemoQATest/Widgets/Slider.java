package DemoQATest.Widgets;

import DemoQATest.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Slider extends BaseClass {
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
    public void test(){

    }
}
