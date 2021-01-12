package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OpenHomePageTest extends  TestBase{


    @Test
    public void homePagTest() {
        System.out.println("site open");


        System.out.println("FindCarPresent" + ifFindCarFromPresent1());
        System.out.println("FindCarPresent" + ifFindCarFromPresent2());
        System.out.println(isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form")));
    }

}
