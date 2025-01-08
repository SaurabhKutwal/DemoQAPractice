package DemoQATest.Elements;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TextBox extends BaseClass {

    String userName = "MotaPanda";
    String email = "tempUser@gmail.com";
    String currAddress = "Pune, Maharashtra India - 411057";
    String permAddress = "Pune, Maharashtra India - 411057";


    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
    }
    @Test
    public void test(){


        driver.findElement(By.id("userName")).sendKeys(userName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permAddress);
        driver.findElement(By.id("submit")).click();

        List<WebElement> elements= driver.findElements(By.xpath("//div[@id = 'output']//p"));
        elements.forEach(element -> System.out.println(element.getText()));
    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
