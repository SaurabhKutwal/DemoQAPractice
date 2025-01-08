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
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WebTables extends BaseClass {

    WebDriverWait wait;

    String firstName = "Player456";
    String lastname = "temp";
    String email = "temp@gmail.com";
    String age = "45";
    String salary = "200000";
    String department = "CS";

    List<WebElement> rowsWithvalue;

    @BeforeTest
    public void startUp(){
        init();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test(priority = 1)
    public void printData(){

        List<WebElement> totalRows = driver.findElements(By.xpath("//div[contains(@class,'ReactTable')]/div/div[contains(@class,'rt-tbody')]/div/div"));
        rowsWithvalue = totalRows.stream().filter(isDataRow).toList();

        rowsWithvalue.forEach(row->{
            List<WebElement> cols = row.findElements(By.xpath("./div"));
            for(int j=1;j<=6;j++){
                System.out.print(cols.get(j-1).getText() + " ");
            }
            System.out.println();
        });
    }

    @Test(priority = 2,dependsOnMethods = "printData")
    public void addData(){
        driver.findElement(By.id("addNewRecordButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'modal-content']")));

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);

        driver.findElement(By.id("submit")).click();
        printData();
    }

    @Test(priority = 3,dependsOnMethods = "addData")
    public void removeData(){
        rowsWithvalue.forEach(row->{
            List<WebElement> cols = row.findElements(By.xpath("./div"));
            if(cols.get(0).getText().equals(firstName)){
                cols.get(6).findElement(By.xpath(".//span[@title = 'Delete']")).click();
            }
        });

        printData();
    }

    @AfterTest
    public void endUp() throws InterruptedException {
        tearDown();
    }

    Predicate<WebElement> isDataRow = (webEle) -> {
        String classVal = webEle.getDomAttribute("class");
        return !classVal.contains("padRow");
    };
}
