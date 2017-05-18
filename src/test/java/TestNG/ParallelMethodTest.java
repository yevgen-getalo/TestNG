package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ParallelMethodTest{
    private WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", "/home/user/Downloads/geckodriver");
        if(driver == null){
            driver = new FirefoxDriver();
            //driver = new ChromeDriver();
        }
        driver.manage().window().setSize(new Dimension(800, 800));
        driver.get("http://google.com");
//        long id = Thread.currentThread().getId();
//        System.out.println("Before test-method. Thread id is: " + id);
    }

    @Test
    public void testMethodsOne() {
        assertTrue(driver.getTitle().equals("Google"));
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id);
    }

    @Test
    public void testMethodsTwo() {
       driver.findElement(By.xpath("//input[@value='Мені пощастить']")).click();
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id);
    }

    @Test
    public void testMethodsThree() {
        driver.findElement(By.xpath("//a[contains(text(), 'Увійти')]")).click();
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id);
    }

    @Test
    public void testMethodsFour() {
        driver.findElement(By.xpath("//a[@title='Додатки Google']")).click();
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four. Thread id is: " + id);
    }

    @AfterMethod
    public void afterMethod() {
        //Thread.currentThread().interrupt();
        //driver.quit();
        //long id = Thread.currentThread().getId();
        //System.out.println("After test-method. Thread id is: " + id);



    }
}
