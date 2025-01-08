package DemoQATest.Elements;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinksAndImages extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void test() throws IOException {
        //Identify broken links

        List<WebElement> links = driver.findElements(By.xpath("//h1[text() = 'Broken Links - Images']/parent::div/a"));
        for (WebElement link : links){
            URL url = new URL(link.getDomAttribute("href"));
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.connect();
            if(connect.getResponseCode() >= 400){
                System.out.println("Status code : " + connect.getResponseCode());
                System.out.println("This is broken link : " + link.getText());
            }

        }

        //Identify broken images
        List<WebElement> images = driver.findElements(By.xpath("//h1[text() = 'Broken Links - Images']/parent::div/img"));
        for (WebElement img : images){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            URL url = new URL((String) js.executeScript("return arguments[0].src",img));
            System.out.println((String) js.executeScript("return arguments[0].src",img));
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.connect();
            if(connect.getResponseCode() >= 400){
                System.out.println("Status code : " + connect.getResponseCode());
                System.out.println("This is broken link : " + img.getDomAttribute("src"));
            }

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", img);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }

        }

        //Validate image display using JavaScript executor


    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
