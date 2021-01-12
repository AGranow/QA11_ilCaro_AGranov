package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static WebDriver wd;

    @BeforeMethod

    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    public boolean ifFindCarFromPresent1() {
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form")).size() > 0;
    }

    // универсальный метод
    public boolean isElementPresent1(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean ifFindCarFromPresent2 () {
        try {
            wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // универсальный метод
    public boolean isElementPresent2(By locator) {
        try {
            wd.findElements(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
