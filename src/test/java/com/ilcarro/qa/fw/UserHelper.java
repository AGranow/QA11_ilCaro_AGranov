package com.ilcarro.qa.fw;

import com.ilcarro.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));  // click on logout form
    }

    public boolean   userLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        fillLoginForm(user);
    }

    public void selectPolisyCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void isRegistrationFormOpened() {
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));
    }

    public void logIn() {
        click(By.cssSelector("[href='/login']"));
        //fill login form
        fillLoginForm(new User()
                .withEmail("MaxSmitt7@gmail.com")
                .withPassword("MaxSmitt1"));
        //submit login
        submitForm();

    }

    public boolean isLoginFormPresent() {
        return isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm"));
    }

}
