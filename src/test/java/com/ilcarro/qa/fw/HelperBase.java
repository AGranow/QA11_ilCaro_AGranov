package com.ilcarro.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HelperBase {

    public  WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent1(By locator) {
        return wd.findElements(locator).size() > 0;
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

    public  void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!= null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void pause(int mills) throws InterruptedException {
        Thread.sleep(mills);
    }

    public boolean ifFindCarFromPresent2() {
        return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }

    // Метод для сдвига страницы вниз
    public void jumpToFutter(){
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
    }
}
