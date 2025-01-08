package DemoQATest.Elements;

import DemoQATest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Links extends BaseClass {
    WebDriverWait wait;
    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/links");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void test(){
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.id("dynamicLink")).click();
        Set<String> windowId = driver.getWindowHandles();
        Iterator<String> itr = windowId.iterator();
        String parent = itr.next();

        for (String s : windowId) {
            driver.switchTo().window(s);
            System.out.println("Current URL is : " + driver.getCurrentUrl());
        }
        driver.switchTo().window(parent);

        List<WebElement> p = driver.findElements(By.xpath("//div[@id = 'linkWrapper']/p"));

        for(int i=3;i<=9;i++){
            String text = p.get(i-1).findElement(By.xpath("./a")).getText();
            p.get(i-1).findElement(By.xpath("./a")).click();
            WebElement linkRes = driver.findElement(By.xpath("//div[@id = 'linkWrapper']/p[@id = 'linkResponse']"));
            wait.until(ExpectedConditions.textToBePresentInElement(linkRes,text));
            System.out.println(linkRes.getText());
        }

    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }
}
