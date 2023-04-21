package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;


public class AppTest {
    ChromeDriver driver;

    @BeforeClass
    void setupDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(20000);
        driver.manage().window().maximize();
        //Full screen.
    }
    @Test()
    void dropdownMethod() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        select.selectByValue("java");

        Select select1 = new Select(driver.findElement(By.id("dropdowm-menu-2")));
        select1.selectByValue("testng");

        Select select2 = new Select(driver.findElement(By.id("dropdowm-menu-3")));
        select2.selectByValue("javascript");
        Thread.sleep(2000);

    }

    @Test
    void checkBoxMethod() throws InterruptedException {

        WebElement e = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input"));
        e.click();
        Thread.sleep(2000);

//        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[3]/input"));
//        e1.click();

    }
    @Test
    void RadioButtonMethod(){
        WebElement radioElement = driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]"));
        radioElement.click();

    }

}
