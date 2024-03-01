package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_User_Register_Login_Repeat_Yourself {
    WebDriver driver;
    String firstName = "Quynh", lastName = "Duong", emailAddress = getEmailAddressRandom(), password = "123456";
    String day = "23", month = "November", year = "2000";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");


    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select dayOfBirth = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dayOfBirth.selectByVisibleText(day);
        Assert.assertEquals(dayOfBirth.getOptions().size(), 32);


        Select monthOfBirth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        monthOfBirth.selectByVisibleText(month);

        Select yearOfBirth = new Select(driver.findElement(By.name("DateOfBirthYear")));
        yearOfBirth.selectByVisibleText(year);


        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-body>.result")).getText(), "Your registration completed");
    }


    @Test
    public void TC_02_Login() {
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".button-1.login-button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        driver.findElement(By.cssSelector("a.ico-account")).click();

        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);
        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long sleepInSecond) {
        try {
            Thread.sleep(sleepInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddressRandom() {
        Random random = new Random();
        // String emaillAddressRandom = "Quynhxoan" + random.nextInt(99999) + "@gmail.com"; (Có thể khai báo biến cho email address)
        return "Quynhxoan" + random.nextInt(99999) + "@gmail.com";
        // return "Quynhxoan" + new Random()nextInt(99999) + "@gmail.com"; (Có thể viết ntn)
    }
}
