package com.ilcarro.qa.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
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

// Метод создающий скриншот
    public String takeScreenshot()  {
      File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
      File screenshot = new File("screenshot"  + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }


}
