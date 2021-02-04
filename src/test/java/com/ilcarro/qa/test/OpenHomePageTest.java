package com.ilcarro.qa.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {


    @Test
    public void homePagTest() {
        System.out.println("site open");

        System.out.println("FindCarPresent" + app.getCar().ifFindCarFromPresent1());
        app.getCar().isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

        app.getCar().jumpToFutter();
    }
}
