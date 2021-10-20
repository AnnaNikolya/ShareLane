package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneTest {
    //1. Open browser, URL - https://www.sharelane.com/cgi-bin/register.py
    //2. Enter value in ZIP code field
    //3. Clik Continue button

    @Test
    public void fillInZipCodeFieldWithEmptyTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("444444");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        String text = driver.findElement(By.xpath("//*[@value='error_massage']")).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @Test
    public void fillInZipCodeFieldWithMandatoryFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("444444");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Amrigest");
        driver.findElement(By.name("email")).sendKeys("Amrigest@yandex.ru");
        driver.findElement(By.name("password1")).sendKeys("444444");
        driver.findElement(By.name("password2")).sendKeys("444444");
        driver.findElement(By.xpath("//*[@value='Register']")).click();

    }
    @Test
    public void fillInZipCodeFieldWithUnMandatoryFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("444444");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("last_name")).sendKeys("AImperal");
        driver.findElement(By.xpath("//*[@value='Register']")).click();

    }

    @Test
    public void fillInZipCodeFieldRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys("howard_khan@2958.0.sharelane.com");
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        driver.findElement(By.name("keyword")).sendKeys("Mark Twain");
        driver.findElement(By.xpath("//*[@value='Search']")).click();

    }

    @Test
    public void fillInZipCodeFieldSearchTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("keyword")).sendKeys("Mark Twain");
        driver.findElement(By.xpath("//*[@value='Search']")).click();

        //driver.findElement(By.name("email")).sendKeys("howard_khan@2958.0.sharelane.com");
        //driver.findElement(By.name("password")).sendKeys("1111");
        //driver.findElement(By.xpath("//*[@value='Login']")).click();
        //driver.findElement(By.name("keyword")).sendKeys("Mark Twain");
        //driver.findElement(By.xpath("//*[@value='Search']")).click();
//
    }}



