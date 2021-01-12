package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent1(By.cssSelector("[href='/signup']"))) {  //   sign up on not present
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click();  // click on logout form


            // //a[contains(.,'logOut')]
            //[href='/signup']
        }
    }

    @Test
    public void testSignUp() {
        wd.findElement(By.cssSelector("[href='/signup']")).click();     //click on SignUp Button
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        // fill registration form
        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("Max");

        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("Smitt");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("MaxSmitt1");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("MaxSmitt1");


        wd.findElement(By.cssSelector("#check_policy")).click();
    }

    //click Submit button
    //check login form displayed

}
