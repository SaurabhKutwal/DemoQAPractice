package DemoQATest.Elements;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButton extends BaseClass {

    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
    }
    @Test
    public void test(){


        driver.findElement(By.xpath("//input[@id = 'yesRadio']//parent::div")).click();
        System.out.println(driver.findElement(By.xpath("//p//span")).getText());

        driver.findElement(By.xpath("//input[@id = 'impressiveRadio']//parent::div")).click();
        System.out.println(driver.findElement(By.xpath("//p//span")).getText());

        System.out.println(driver.findElement(By.id("noRadio")).isEnabled());;

    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
